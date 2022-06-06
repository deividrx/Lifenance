package controller;

import dal.GenericDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import validation.Validation;

import java.io.IOException;

@WebServlet(name = "Register", urlPatterns = {"/authorization/register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String cpf = req.getParameter("cpf");
        String email = req.getParameter("email");
        String pwd = req.getParameter("password");
        String repeatPwd = req.getParameter("repeatPassword");

        if (!Validation.validateCpf(cpf)) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid cpf!");
            return;
        }

        if (!pwd.equals(repeatPwd)) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "password not equals!");
            return;
        }

        GenericDao<User> userDao = new GenericDao<>("users", User.class);
        User user = new User(firstName, lastName, cpf, email, pwd);
        userDao.insertWithPK(user);

        resp.sendRedirect("lifenance/login.html");
    }
}
