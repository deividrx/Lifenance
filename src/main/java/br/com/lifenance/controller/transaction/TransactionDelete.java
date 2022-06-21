package br.com.lifenance.controller.transaction;

import br.com.lifenance.application.Application;
import br.com.lifenance.controller.JsonMenssage;
import br.com.lifenance.dal.GenericDao;
import br.com.lifenance.models.*;
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
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "TransactionDelete", urlPatterns = {"/controller/transaction/delete"})
public class TransactionDelete extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(Application.class);
    private final GenericDao<Transaction> transactionDao = new GenericDao<>("transactions", Transaction.class);
    private final GenericDao<TransactionAccount> transactionAccountDao = new GenericDao<>("transactions_bank_accounts", TransactionAccount.class);
    private final GenericDao<Account> accountDao = new GenericDao<>("bank_accounts", Account.class);
    private final GenericDao<Card> cardDao = new GenericDao<>("cards", Card.class);
    private final GenericDao<TransactionCard> transactionCardDao = new GenericDao<>("transactions_cards", TransactionCard.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String transactionId = req.getParameter("id");
            System.out.println("id_transaction=" + transactionId);
            JsonMenssage jsonMenssage = new JsonMenssage(resp);

            transactionAccountDao.remove(transactionAccountDao.getList(transactionId, "transaction_id").iterator().next().getId());

            TransactionCard aux = transactionCardDao.getList(transactionId, "transaction_id").iterator().next();

            if (aux != null) {
                transactionCardDao.remove(aux.getIdTransactionCard());
            }

            transactionDao.remove(Long.parseLong(transactionId));
            jsonMenssage.sendInfo("Conta Bancária deletada com sucesso!");
        } catch (Exception error) {
            logger.error(error);
        }
    }
}
