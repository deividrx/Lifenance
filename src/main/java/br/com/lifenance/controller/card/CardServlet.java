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

@WebServlet(name = "Card", urlPatterns = {"/controller/card"})
public class CardServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(Application.class);
    private final GenericDao<Card> cardDao = new GenericDao<>("cards", Card.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String bandeira = req.getParameter("bandeira");
            String nomeCard = req.getParameter("username");
            String numCard = req.getParameter("cardNumber");
            String validadeMes = req.getParameter("validadeMes");
            String validadeAno = req.getParameter("validadeAno");
            String limiteCartao = req.getParameter("limiteCard");
            System.out.println(limiteCartao);
            String faturaMes = req.getParameter("fatura-mes");

            JsonMenssage jsonMenssage = new JsonMenssage(resp);
            User user = (User) req.getSession(false).getAttribute("loggedUser");

            Card card = new Card(
                    Long.parseLong(numCard),
                    LocalDate.parse(validadeAno + "-" + validadeMes + "-" + "10"),
                    ModelFactory.getModel(CardFlag.class, "card_flags", Long.parseLong(bandeira)),
                    0,
                    Integer.parseInt(limiteCartao),
                    null,
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
