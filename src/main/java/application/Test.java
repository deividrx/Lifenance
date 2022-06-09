package application;

import models.ModelFactory;
import models.User;

public class Test {
    public static void main(String[] args) {

        try {
            User user = ModelFactory.getModel(User.class, "users", Long.parseLong("35967709045"));
            System.out.println(user.toString());
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
