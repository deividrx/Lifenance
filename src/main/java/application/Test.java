package application;

import dal.GenericDao;
import models.ModelFactory;
import models.User;

public class Test {
    public static void main(String[] args) {

        try {
            GenericDao<User> userGenericDao = new GenericDao<>("users", User.class);
            System.out.println(ModelFactory.getModel(User.class, "users", Long.parseLong("11111111111")));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
