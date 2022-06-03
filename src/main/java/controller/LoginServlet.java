
package com.journaldev.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import dal.GenericDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private GenericDao<User> userDao;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        userDao = new GenericDao<>("users", User.class);

        String cpf = request.getParameter("cpf");

        User user = null;
        for (User aux : userDao.getList()) {
            if (aux.getCpf().equals(cpf)) {
                user = aux;
                System.out.println(user.toString());
            }
        }

        String pwd = request.getParameter("password");

        if(user != null && pwd.equals(user.getPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("user_id", user.getId());
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);
            Cookie userName = new Cookie("user", Long.toString(user.getId()));
            userName.setMaxAge(30*60);
            response.addCookie(userName);
            response.sendRedirect("index.html");
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("login.html");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }

    }

}