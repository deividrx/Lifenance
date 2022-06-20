package br.com.lifenance.controller;

import br.com.lifenance.application.Application;
import br.com.lifenance.dal.GenericDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.com.lifenance.models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import br.com.lifenance.validation.Validation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Register", urlPatterns = {"/authorization/register"})
public class RegisterServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(Application.class);
    private final Map<String, Object> map = new HashMap<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String firstName = req.getParameter("first_name");
            String lastName = req.getParameter("last_name");
            String cpf = req.getParameter("cpf");
            String email = req.getParameter("email");
            String pwd = req.getParameter("password");
            String repeatPwd = req.getParameter("repeatPassword");

            JsonMenssage jsonMenssage = new JsonMenssage(resp);

            if (!Validation.validateCpf(cpf)) {
                jsonMenssage.sendError("CPF inválido!");
                return;
            }

            if (!pwd.equals(repeatPwd)) {
                jsonMenssage.sendError("Senha não iguais!");
                return;
            }

            GenericDao<User> userDao = new GenericDao<>("users", User.class);

            if (userDao.contains(cpf)) {
                jsonMenssage.sendError("Este CPF já foi cadastrado!");
                return;
            }

            User user = new User(firstName, lastName, cpf, email, pwd);
            userDao.insertWithPK(user);

            jsonMenssage.sendInfo("Usuário criado com sucesso!");

        } catch (IOException error) {
            logger.error(error);
        }
    }
}
