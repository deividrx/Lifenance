package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.google.gson.Gson;
import dal.GenericDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import validation.Dados;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    private GenericDao<User> daoUser = new GenericDao<>("users", User.class);

    protected void processLogin(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Map<String, Object> map = new HashMap<>();
        String[] infoUser = {request.getParameter("cpf"), request.getParameter("email_login"),};


        for (User aux : daoUser.getList()) {
            System.out.println(aux.toString());
            if (Objects.equals(aux.getCpf(), infoUser[0]) && Objects.equals(aux.getPassword(), infoUser[1])) {
                map.put("erro", false);
                map.put("text", "Usuário logado com sucesso!");
                return;
            }
        }

        map.put("erro", true);
        map.put("text", "Usuário não existe!");
        doResponse(response, map);

    }


    protected void doResponse(HttpServletResponse response, Map<String, Object> jsonMap) throws IOException {
        try (PrintWriter output = response.getWriter()) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            output.write(new Gson().toJson(jsonMap));
        }
    }




    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processLogin(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
