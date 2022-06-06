package controller;

import dal.GenericDao;
import jakarta.servlet.http.HttpServletRequest;
import models.User;

public class Authorization {
    public static boolean isLoggedIn(HttpServletRequest request) {
        return false;
    }

    public static boolean validateLogin(String login, String password) {
        GenericDao<User> user = new GenericDao<>("users", User.class);
        long id = Long.parseLong(login);

        if (user.contains(id)) {
            return (user.get(id).getPwd().equals(password));
        } else {
            return false;
        }
    }
}
