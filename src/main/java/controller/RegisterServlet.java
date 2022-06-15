package controller;

import application.Application;
import com.google.gson.Gson;
import dal.GenericDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import validation.Validation;

import java.io.IOException;
import java.io.PrintWriter;
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

            JsonMenssage jsonMenssage = new JsonMenssage(map);

            if (!Validation.validateCpf(cpf)) {
                map.put("error", true);
                map.put("text", "CPF inválido!");
                jsonMenssage.returnJson(resp);
                return;
            }

            if (!pwd.equals(repeatPwd)) {
                map.put("error", true);
                map.put("text", "Senha não iguais!");
                jsonMenssage.returnJson(resp);
                return;
            }

            GenericDao<User> userDao = new GenericDao<>("users", User.class);
            User user = new User(firstName, lastName, cpf, email, pwd);
            userDao.insertWithPK(user);

            map.put("error", false);
            map.put("text", "Usuário criado com sucesso!");
            jsonMenssage.returnJson(resp);

        } catch (IOException error) {
            logger.error(error);
        }
    }
}
