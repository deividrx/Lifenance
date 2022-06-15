package controller;

import application.Application;
import dal.GenericDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import validation.Validation;

import java.io.IOException;

@WebServlet(name = "Register", urlPatterns = {"/authorization/register"})
public class RegisterServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(Application.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String firstName = req.getParameter("first_name");
            String lastName = req.getParameter("last_name");
            String cpf = req.getParameter("cpf");
            String email = req.getParameter("email");
            String pwd = req.getParameter("password");
            String repeatPwd = req.getParameter("repeatPassword");

            if (!Validation.validateCpf(cpf)) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Cpf!");
                return;
            }

            if (!pwd.equals(repeatPwd)) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Password not equals!");
                return;
            }

            GenericDao<User> userDao = new GenericDao<>("users", User.class);
            User user = new User(firstName, lastName, cpf, email, pwd);
            userDao.insertWithPK(user);

        } catch (IOException error) {
            logger.error(error);
        }
    }
}
