package bll;

import dal.GenericDao;
import jakarta.servlet.http.HttpServletRequest;
import models.Session;
import models.User;

public class Authorization {

    private final GenericDao<User> userDao = new GenericDao<>("users", User.class);
    private final GenericDao<Session> sessionDao = new GenericDao<>("sessions", Session.class);

    public boolean isLoggedIn(HttpServletRequest request) {
        if (request.getSession(false) != null) {
            return sessionDao.contains(request.getSession().getId());
        }
        return false;
    }

    public void createSession() {

    }

    public boolean validateLogin(String login, String password) {
        long id = Long.parseLong(login);

        if (userDao.contains(id)) {
            return (userDao.get(id).getPwd().equals(password));
        } else {
            return false;
        }
    }

    public void insertUser(String firstName, String lastName, String cpf, String email, String pwd) {
        User user = new User(firstName, lastName, cpf, email, pwd);
        userDao.insertWithPK(user);
    }
}