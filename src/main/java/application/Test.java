package application;

import dal.GenericDao;
import models.ModelFactory;
import models.User;
import org.apache.commons.lang3.RandomStringUtils;

public class Test {
    public static void main(String[] args) {

        try {
            GenericDao<User> userGenericDao = new GenericDao<>("users", User.class);
            System.out.println(ModelFactory.getModel(User.class, "users", Long.parseLong("11111111111")));
            System.out.println(RandomStringUtils.randomAlphanumeric(64));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
