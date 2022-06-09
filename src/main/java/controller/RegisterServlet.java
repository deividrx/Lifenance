package controller;

import com.google.gson.Gson;
import dal.GenericDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import validation.Validation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Register", urlPatterns = {"/authorization/register"})
public class RegisterServlet extends HttpServlet {

    private final Map<String, Object> map = new HashMap<>();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String cpf = req.getParameter("cpf");
        String email = req.getParameter("email");
        String pwd = req.getParameter("password");
        String repeatPwd = req.getParameter("repeatPassword");

        if (!Validation.validateCpf(cpf)) {
            map.put("error", true);
            map.put("text", "invalid cpf");
            returnJson(resp);
            return;
        }

        if (!pwd.equals(repeatPwd)) {
            map.put("error", true);
            map.put("text", "invalid password");
            returnJson(resp);
            return;
        }

        GenericDao<User> userDao = new GenericDao<>("users", User.class);
        User user = new User(firstName, lastName, cpf, email, pwd);
        userDao.insertWithPK(user);

        map.put("error", false);
        map.put("text", "Sucesso");
        returnJson(resp);
    }

    public void returnJson(HttpServletResponse resp) throws IOException {
        try (PrintWriter output = resp.getWriter()) {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            output.write(new Gson().toJson(map));
        }
    }
}
