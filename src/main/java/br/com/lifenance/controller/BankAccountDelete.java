package br.com.lifenance.controller;

import br.com.lifenance.application.Application;
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

@WebServlet(name = "BankAccountDelete", urlPatterns = {"/controller/bank-account/delete"})
public class BankAccountDelete extends  HttpServlet {

    private static final Logger logger = LogManager.getLogger(Application.class);
    private final GenericDao<Account> accountDao = new GenericDao<>("bank_accounts", Account.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String contaId = req.getParameter("id");

            System.out.println("id_conta=" + contaId);

        } catch (Exception error) {
            logger.error(error);
        }
    }
}

