
package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import dal.GenericDao;
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
import models.Session;
import models.exceptions.HashGenerationException;
import util.HashGenerator;

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
                System.out.println("bacate");
                String selector = null;
                String rawValidator = null;

                for (Cookie aCookie : cookies) {
                    System.out.println(aCookie.getName());
                    switch (aCookie.getName()) {
                        case "selector" -> selector = aCookie.getValue();
                        case "validator" -> rawValidator = aCookie.getValue();
                    }
                }

                if (selector != null && rawValidator != null) {
                    GenericDao<Session> sessionDAO = new GenericDao<>( "user_sessions", Session.class);
                    Session userSession = sessionDAO.getByColumn("selector", selector);
                    System.out.println("bacate");

                    if (userSession != null) {
                        String hashedValidatorDatabase = userSession.getValidator();
                        String hashedValidatorCookie = HashGenerator.generateSHA256(rawValidator);
                        System.out.println("bacate");

                        if (hashedValidatorCookie.equals(hashedValidatorDatabase)) {
                            session = req.getSession();
                            session.setAttribute("loggedCustomer", userSession.getUser());
                            logged = true;
                            System.out.println("bacate");
                        }
                    }
                }
            }

            String uri = req.getRequestURI();

            if (uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".map")) {
                chain.doFilter(request, response);
                return;
            }

            if (!logged && !pagesWithoutLoginAcess(uri)) {
                res.sendRedirect("deny-access.html");
            } else {
                if (logged && (uri.endsWith("login.html") || uri.endsWith("register.html")))
                    res.sendRedirect("index.html");
                else
                    chain.doFilter(request, response);
            }

        } catch (HashGenerationException error) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, error);
        }
    }

    private boolean pagesWithoutLoginAcess(String uri) {
        return (uri.endsWith("login.html") || uri.endsWith("deny-access.html") || uri.endsWith("/authorization/register") ||
                uri.endsWith("/authorization/login") || uri.endsWith("register.html"));
    }
}
