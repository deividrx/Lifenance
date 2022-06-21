package br.com.lifenance.controller.transaction;

import br.com.lifenance.application.Application;
import br.com.lifenance.dal.GenericDao;
import br.com.lifenance.models.Transaction;
import br.com.lifenance.models.User;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TransactionReceita", urlPatterns = {"/controller/transaction/receita"})
public class ReceitaList extends HttpServlet {

    private final GenericDao<Transaction> transactionDao = new GenericDao<>("transactions", Transaction.class);
    private static final Logger logger = LogManager.getLogger(Application.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            User user = (User) req.getSession(false).getAttribute("loggedUser");
            PrintWriter output = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(LocalDate.class, new GsonLocalDate());
            Gson gson = gsonBuilder.setPrettyPrinting().create();
            List<Transaction> listTransaction = new ArrayList<>();

            for (Transaction aux : transactionDao.getList(user.getCpf(), "user_cpf")) {
                if (aux.getValue() > 0) {
                    listTransaction.add(aux);
                }
            }

            output.write(gson.toJson(listTransaction));
        } catch (Exception error) {
            logger.error(error);
        }
    }
}
