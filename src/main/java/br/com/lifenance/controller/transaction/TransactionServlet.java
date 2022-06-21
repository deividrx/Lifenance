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
    private final GenericDao<TransactionAccount> transactionAccountDao = new GenericDao<>("transactions_bank_accounts", TransactionAccount.class);
    private final GenericDao<Account> accountDao = new GenericDao<>("bank_accounts", Account.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String nome = req.getParameter("nomeReceita");
            String valor = req.getParameter("valorReceita");
            String dataInicio = req.getParameter("dataInicio");
            String dataFim = req.getParameter("dataFim");
            String conta = req.getParameter("conta");
            String description = req.getParameter("description");

            JsonMenssage jsonMenssage = new JsonMenssage(resp);
            User user = (User) req.getSession(false).getAttribute("loggedUser");
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-M-d");

            Transaction transaction = new Transaction();
            transaction.setName(nome);
            transaction.setValue(Float.parseFloat(valor));
            transaction.setDataInicial(LocalDate.parse(dataInicio, df));
            transaction.setDescription(description);
            transaction.setUser(user);
            if (dataFim != null)
                transaction.setDataFinal(LocalDate.parse(dataFim, df));
            else
                transaction.setDataFinal(null);

            long id = transactionDao.insertReturnId(transaction);
            transaction.setIdTransaction(id);

            TransactionAccount transactionAccount = new TransactionAccount();
            transactionAccount.setTransaction(transaction);
            transactionAccount.setAccount(accountDao.get(Long.parseLong(conta)));

            transactionAccountDao.insert(transactionAccount);

            jsonMenssage.sendInfo("Receita cadastrada com sucesso!");

        } catch (Exception error) {
            logger.error(error);
        }
    }
}