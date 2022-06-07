package application;

import dal.FieldHandler;
import dal.GenericDao;
import models.Session;
import models.User;
import org.webjars.WebJarAssetLocator;

import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {

        try {
//            GenericDao<Session> sessionDao = new GenericDao<>("sessions", Session.class);
//            Session session = new Session();
//            session.setSessionId(Long.MAX_VALUE);
//            session.setUser(new User("bacqate", "bacate", "123123", "1asdfasdf", "213123"));
//
//            sessionDao.insert(session);

            WebJarAssetLocator locator = new WebJarAssetLocator();
            Set<String> fullPathsOfAssets = locator.listAssets();

            for (String aux : fullPathsOfAssets) {
                System.out.println(aux);
            }

        } catch (Exception e) {
            System.out.println(e);
        }





    }

}
