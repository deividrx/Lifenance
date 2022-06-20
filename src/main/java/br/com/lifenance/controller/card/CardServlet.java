package br.com.lifenance.controller.card;

import br.com.lifenance.application.Application;
import br.com.lifenance.controller.JsonMenssage;
import br.com.lifenance.dal.GenericDao;
import br.com.lifenance.models.Account;
import br.com.lifenance.models.User;
import br.com.lifenance.models.enumeration.AccountType;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(name = "Card", urlPatterns = {"/controller/card"})
public class CardServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(Application.class);
    //private final GenericDao<Account> accountDao = new GenericDao<>("bank_accounts", Account.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String nomeCard = req.getParameter("username");
            String numCard = req.getParameter("cardNumber");
            String validadeMes = req.getParameter("validadeMes");
            String validadeAno = req.getParameter("validadeAno");
            String faturaMes = req.getParameter("fatura-mes");
            String faturaAno = req.getParameter("fatura-ano");

            System.out.println(

                nomeCard +
                numCard +
                validadeMes +
                validadeAno +
                faturaMes +
                    faturaAno
            );

            JsonMenssage jsonMenssage = new JsonMenssage(resp);
            //User user = (User) req.getSession(false).getAttribute("loggedUser");

//            Account account = new Account(
//                    Integer.parseInt(numAccount),
//                    Integer.parseInt(numAgencia),
//                    AccountType.valueOf(tipo.toUpperCase()),
//                    Float.parseFloat(limite),
//                    nomeBanco, user
//            );

            //accountDao.insert(account);
            jsonMenssage.sendInfo("Conta Bancária cadastrada com sucesso!");

        } catch (Exception error) {
            logger.error(error);
        }
    }
}
