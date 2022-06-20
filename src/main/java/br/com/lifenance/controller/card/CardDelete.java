package br.com.lifenance.controller.card;

import br.com.lifenance.application.Application;
import br.com.lifenance.controller.JsonMenssage;
import br.com.lifenance.dal.GenericDao;
import br.com.lifenance.models.Account;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(name = "CardDelete", urlPatterns = {"/controller/card/delete"})
public class CardDelete extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(Application.class);
    private final GenericDao<Account> accountDao = new GenericDao<>("bank_accounts", Account.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String contaId = req.getParameter("id");
            System.out.println("id_conta=" + contaId);
            JsonMenssage jsonMenssage = new JsonMenssage(resp);

            accountDao.remove(Long.parseLong(contaId));
            jsonMenssage.sendInfo("Conta Bancária deletada com sucesso!");
            
        } catch (Exception error) {
            logger.error(error);
        }
    }
}
