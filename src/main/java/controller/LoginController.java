package controller;

import java.io.IOException;
import java.io.PrintWriter;

import dal.GenericDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {


    protected void processLogin(HttpServletRequest request, HttpServletResponse response) {
        try (PrintWriter out = response.getWriter()) {
            out.println("<img src=\"./bacate.jpeg\" width=\"500\" height=\"600\"> ");
        } catch (Exception IOException) {

        }
    }










    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        GenericDao<User> userDao = new GenericDao<>("users", User.class);
        PrintWriter out = response.getWriter();
        for (User aux : userDao.listing()) {
            out.println(aux.toString());
        }
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
