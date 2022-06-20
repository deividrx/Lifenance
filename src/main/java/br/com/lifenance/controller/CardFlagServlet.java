package br.com.lifenance.controller;

import br.com.lifenance.application.Application;
import br.com.lifenance.dal.GenericDao;
import br.com.lifenance.models.CardFlag;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintWriter;

@WebServlet(name = "CardFlag", urlPatterns = {"/controller/card-flag"})
public class CardFlagServlet extends HttpServlet {

    private final GenericDao<CardFlag> cardFlagDao = new GenericDao<>("card_flags", CardFlag.class);
    private static final Logger logger = LogManager.getLogger(Application.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            PrintWriter output = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            output.write(new Gson().toJson(cardFlagDao.getList()));
        } catch (Exception error) {
            logger.error(error);
        }
    }
}
