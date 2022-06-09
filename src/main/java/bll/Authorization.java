package bll;

import dal.GenericDao;
import jakarta.servlet.http.HttpServletRequest;
import models.User;

public class Authorization {

    private final GenericDao<User> userDao = new GenericDao<>("users", User.class);

    public boolean isLoggedIn(HttpServletRequest request) {
        return false;
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