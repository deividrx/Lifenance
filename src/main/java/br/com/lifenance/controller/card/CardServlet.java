package br.com.lifenance.controller.card;

import br.com.lifenance.application.Application;
import br.com.lifenance.controller.JsonMenssage;
import br.com.lifenance.dal.GenericDao;
import br.com.lifenance.models.*;
import br.com.lifenance.models.enumeration.AccountType;
import br.com.lifenance.util.GsonLocalDate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintWriter;
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
            String nomeCard = req.getParameter("username");
            String numCard = req.getParameter("cardNumber");
            String validadeMes = req.getParameter("validadeMes");
            String validadeAno = req.getParameter("validadeAno");
            String limiteCartao = req.getParameter("limiteCard");
            String multa = req.getParameter("card-multa");
            String faturaDia = req.getParameter("fatura-dia");

            JsonMenssage jsonMenssage = new JsonMenssage(resp);
            User user = (User) req.getSession(false).getAttribute("loggedUser");
            DateTimeFormatter df = DateTimeFormatter.ofPattern("d-M-yyyy");

            Card card = new Card(
                    Long.parseLong(numCard),
                    LocalDate.parse( LocalDate.now().getDayOfMonth() + "-" + validadeMes + "-" + validadeAno, df),
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            PrintWriter output = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(LocalDate.class, new GsonLocalDate());


            Gson gson = gsonBuilder.setPrettyPrinting().create();
            output.write(gson.toJson(cardDao.getList()));

        } catch (Exception error) {
            logger.error(error);
        }
    }
}
