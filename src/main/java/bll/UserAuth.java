package bll;

import dal.GenericDao;
import models.Session;
import models.User;

public class UserAuth {

    private final String userPassword;
    private final long userCpf;

    private final GenericDao<User> userDao = new GenericDao<>("users", User.class);
    private final GenericDao<Session> sessionDao = new GenericDao<>("user_sessions", Session.class);

    public UserAuth(String cpf, String password) {
        this.userPassword = password;
        this.userCpf = Long.parseLong(cpf);
    }

    public boolean validateLogin() {
        if (userDao.contains(userCpf)) {
            return (userDao.get(userCpf).getPwd().equals(userPassword));
        } else {
            return false;
        }
    }

    public User getUser() {
       return userDao.get(userCpf);
    }

    public void insertSession(Session session) {
        sessionDao.insert(session);
    }
}