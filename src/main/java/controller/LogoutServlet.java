package controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import dal.GenericDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Session;

@WebServlet(name = "Logout", urlPatterns = {"/authorization/logout"})
public class LogoutServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getSession(false).invalidate();
            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                String sessionId = null;

                for (Cookie aCookie : cookies) {
                    if (aCookie.getName().equals("session_id")) {
                        sessionId = aCookie.getValue();
                    }
                }

                if (sessionId != null) {
                    GenericDao<Session> sessionDAO = new GenericDao<>( "user_sessions", Session.class);
                    Session userSession = sessionDAO.get(sessionId);

                    if (userSession != null) {
                        sessionDAO.remove(userSession.getSessionId());

                        Cookie cookieSelector = new Cookie("session_id", "");
                        cookieSelector.setMaxAge(0);
                        cookieSelector.setPath("/");

                        Cookie cookieValidator = new Cookie("validator", "");
                        cookieValidator.setMaxAge(0);
                        cookieValidator.setPath("/");

                        response.addCookie(cookieSelector);
                        response.addCookie(cookieValidator);
                    }
                }
            }

            response.sendRedirect("/login.jsp");
        } catch (Exception error) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, error);
        }

    }

}

