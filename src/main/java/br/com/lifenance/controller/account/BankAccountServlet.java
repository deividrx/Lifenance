package br.com.lifenance.controller.account;

import br.com.lifenance.application.Application;
import br.com.lifenance.controller.JsonMenssage;
import br.com.lifenance.dal.GenericDao;
import br.com.lifenance.models.Account;
import br.com.lifenance.models.User;
import br.com.lifenance.models.enumeration.AccountType;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintWriter;

@WebServlet(name = "BankAccount", urlPatterns = {"/controller/bank-account"})
public class BankAccountServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(Application.class);
    private final GenericDao<Account> accountDao = new GenericDao<>("bank_accounts", Account.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String nomeBanco = req.getParameter("nomeBanco");
            String numAgencia = req.getParameter("numAgencia");
            String numAccount = req.getParameter("numAccount");
            String limite = req.getParameter("limiteConta");
            String tipo = req.getParameter("gridRadios");

            JsonMenssage jsonMenssage = new JsonMenssage(resp);
            User user = (User) req.getSession(false).getAttribute("loggedUser");

            Account account = new Account(
                    Integer.parseInt(numAccount),
                    Integer.parseInt(numAgencia),
                    AccountType.valueOf(tipo.toUpperCase()),
                    Float.parseFloat(limite),
                    nomeBanco, user
            );

            accountDao.insert(account);
            jsonMenssage.sendInfo("Conta Bancária cadastrada com sucesso!");

        } catch (Exception error) {
            logger.error(error);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            User user = (User) req.getSession(false).getAttribute("loggedUser");
            PrintWriter output = resp.getWriter();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            output.write(new Gson().toJson(accountDao.getList(user.getCpf(), "user_cpf")));
        } catch (Exception error) {
            logger.error(error);
        }
    }
}
