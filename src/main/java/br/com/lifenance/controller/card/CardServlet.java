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

@WebServlet(name = "Card", urlPatterns = {"/controller/card"})
public class CardServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(Application.class);
    private final GenericDao<Card> cardDao = new GenericDao<>("cards", Card.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String bandeira = req.getParameter("bandeira");
            System.out.println(bandeira);
            String nomeCard = req.getParameter("username");
            System.out.println(nomeCard);
            String numCard = req.getParameter("cardNumber");
            System.out.println(numCard);
            String validadeMes = req.getParameter("validadeMes");
            System.out.println(validadeMes);
            String validadeAno = req.getParameter("validadeAno");
            System.out.println(validadeAno);
            String limiteCartao = req.getParameter("limiteCard");
            System.out.println(limiteCartao);
            String multa = req.getParameter("card-multa");
            System.out.println(multa);
            String faturaDia = req.getParameter("fatura-dia");
            System.out.println(faturaDia);

            JsonMenssage jsonMenssage = new JsonMenssage(resp);
            User user = (User) req.getSession(false).getAttribute("loggedUser");
            DateTimeFormatter df = DateTimeFormatter.ofPattern("ddMMyyyy");

            Card card = new Card(
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

            cardDao.insert(card);
            jsonMenssage.sendInfo("Catão cadastrado com sucesso!");

        } catch (Exception error) {
            logger.error(error);
        }
    }
}
