
package br.com.lifenance.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.lifenance.dal.GenericDao;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import br.com.lifenance.models.Session;
import br.com.lifenance.models.exceptions.HashGenerationException;
import br.com.lifenance.util.HashGenerator;

@WebFilter("/*")
public class SessionFilter implements Filter {

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        ServletContext context = fConfig.getServletContext();
        context.log("AuthenticationFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession session = req.getSession(false);
            Cookie[] cookies = req.getCookies();
            boolean logged = (session != null && session.getAttribute("loggedUser") != null);

            if (!logged && cookies != null) {
                String sessionId = null;
                String rawValidator = null;

                for (Cookie aCookie : cookies) {
                    switch (aCookie.getName()) {
                        case "session_id" -> sessionId = aCookie.getValue();
                        case "validator" -> rawValidator = aCookie.getValue();
                    }
                }

                if (sessionId != null && rawValidator != null) {
                    GenericDao<Session> sessionDAO = new GenericDao<>( "user_sessions", Session.class);
                    Session userSession = sessionDAO.get(sessionId);

                    if (userSession != null) {
                        String hashedValidatorDatabase = userSession.getValidator();
                        String hashedValidatorCookie = HashGenerator.generateSHA256(rawValidator);

                        if (hashedValidatorCookie.equals(hashedValidatorDatabase)) {
                            session = req.getSession(true);
                            session.setAttribute("loggedUser", userSession.getUser());
                            logged = true;
                            System.out.println(session.getId());
                        }
                    }
                }
            }

            String uri = req.getRequestURI();
            if (!logged && !pagesWithoutLoginAcess(uri)) {
                res.sendRedirect("/deny-access.html");
            } else {
                if (logged && (uri.endsWith("login.jsp") || uri.endsWith("register.jsp")))
                    res.sendRedirect("/index.jsp");
                else
                    chain.doFilter(request, response);
            }

        } catch (HashGenerationException error) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, error);
        }
    }

    private boolean pagesWithoutLoginAcess(String uri) {
        return (uri.endsWith("login.jsp") || uri.endsWith("deny-access.html") || uri.endsWith("/authorization/register") ||
                uri.endsWith("/authorization/login") || uri.endsWith("register.jsp") || uri.endsWith(".css") || uri.endsWith(".js")
                || uri.endsWith("img/money-image-coins.jpg") || uri.endsWith("img/money.jpg") || uri.endsWith("favicon.ico"));
    }
}
