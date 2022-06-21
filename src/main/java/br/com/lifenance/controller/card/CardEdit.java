package br.com.lifenance.controller.card;

import br.com.lifenance.application.Application;
import br.com.lifenance.controller.JsonMenssage;
import br.com.lifenance.dal.GenericDao;
import br.com.lifenance.models.*;
import br.com.lifenance.models.enumeration.AccountType;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "CardEdit", urlPatterns = {"/controller/card/edit"})
public class CardEdit extends HttpServlet {

    private final GenericDao<Card> cardDao = new GenericDao<>("cards", Card.class);
    private static final Logger logger = LogManager.getLogger(Application.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String id = req.getParameter("id");
            String bandeira = req.getParameter("bandeira");
            String nomeCard = req.getParameter("username");
            String numCard = req.getParameter("cardNumber");
            String validadeMes = req.getParameter("validadeMes");
            String validadeAno = req.getParameter("validadeAno");
            String limiteCartao = req.getParameter("limiteCard");
            String multa = req.getParameter("card-multa");
            String faturaDia = req.getParameter("fatura-dia");

            JsonMenssage jsonMenssage = new JsonMenssage(resp);
            User user = (User) req.getSession(false).getAttribute("loggedUser");
            DateTimeFormatter df = DateTimeFormatter.ofPattern("ddMMyyyy");

            Card card = new Card(
                    Long.parseLong(id),
                    Long.parseLong(numCard),
                    LocalDate.parse( LocalDate.now().getDayOfMonth() + validadeMes + validadeAno, df),
                    ModelFactory.getModel(CardFlag.class, "card_flags", Long.parseLong(bandeira)),
                    Integer.parseInt(multa),
                    Integer.parseInt(limiteCartao),
                    Integer.parseInt(faturaDia),
                    nomeCard,
                    user
            );

            System.out.println(card.toString());

            //cardDao.update(card);
            jsonMenssage.sendInfo("Cartão Alterada com sucesso!");
        } catch (Exception error) {
            logger.error(error);
        }
    }
}
