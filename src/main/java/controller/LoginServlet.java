
package controller;

import java.io.IOException;

import bll.Authorization;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(name = "Login", urlPatterns = {"/authorization/login"})
public class LoginServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(LoginServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Authorization authorization = new Authorization();
            logger.info("Reached login!");
            if (!authorization.isLoggedIn(request)) {
                String cpf = request.getParameter("cpf");
                String password = request.getParameter("password");
                boolean remember = Boolean.parseBoolean(request.getParameter("remember"));

                logger.info("Reached login: pwd=" + password + " cpf=" + cpf + " remeber=" + remember);
                if (!authorization.validateLogin(cpf, password)) {
                    logger.info("Failed login from " + request.getRemoteAddr());
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid username or password!");
                    return;
                }

                HttpSession session = request.getSession();
                session.setAttribute("user_id", "bacate");
                //setting session to expiry in 30 mins
                session.setMaxInactiveInterval(30*60);
                Cookie userName = new Cookie("user", "11111");
                userName.setMaxAge(30*60);
                response.addCookie(userName);
                response.sendRedirect("index.html");

            }

            response.sendRedirect("index.html");
        } catch (Exception e) {

        }


        System.out.println();






//        if(user != null && pwd.equals(user.getPassword())){
//        }else{
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("login.html");
//            PrintWriter out= response.getWriter();
//            out.println("<font color=red>Either user name or password is wrong.</font>");
//            rd.include(request, response);
//        }

    }

}