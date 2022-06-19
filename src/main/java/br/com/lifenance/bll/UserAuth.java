package br.com.lifenance.bll;

import br.com.lifenance.dal.GenericDao;
import br.com.lifenance.models.Session;
import br.com.lifenance.models.User;

public class UserAuth {

    private final String userPassword;
    private final String userCpf;

    private final GenericDao<User> userDao = new GenericDao<>("users", User.class);
    private final GenericDao<Session> sessionDao = new GenericDao<>("user_sessions", Session.class);

    public UserAuth(String cpf, String password) {
        this.userPassword = password;
        this.userCpf = cpf;
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
        sessionDao.insertWithPK(session);
    }
}