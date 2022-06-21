package br.com.lifenance.controller.transaction;

import br.com.lifenance.application.Application;
import br.com.lifenance.controller.JsonMenssage;
import br.com.lifenance.dal.GenericDao;
import br.com.lifenance.models.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "Receita", urlPatterns = {"/controller/receita"})
public class TransactionServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(Application.class);
    private final GenericDao<Transaction> transactionDao = new GenericDao<>("transactions", Transaction.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String nome = req.getParameter("nomeReceita");
            System.out.println(nome);
            String valor = req.getParameter("valorReceita");
            System.out.println(valor);
            
            String dataInicio = req.getParameter("dataInicio");
            System.out.println(dataInicio);
            String dataFim = req.getParameter("dataFim");
            System.out.println(dataFim);
            
            String conta = req.getParameter("conta");
            System.out.println(conta);
            
            String description = req.getParameter("description");
            System.out.println(description);
            

        } catch (Exception error) {
            logger.error(error);
        }
    }
}
