package application;

import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.StandardRoot;

import java.awt.*;
import java.io.File;
import java.net.URL;

public class Application {
    
    public static void main(String[] args) {
        try {
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(8888);
            tomcat.getConnector();

            String webapp = "src/main/webapp/";
            Context context = tomcat.addWebapp("/lifenance", new File(webapp).getAbsolutePath());

            WebResourceRoot resources = new StandardRoot(context);
            context.setResources(resources);

            tomcat.start();

            Desktop.getDesktop().browse(new URL("http://localhost:8888/lifenance").toURI());
            tomcat.getServer().await();

        } catch (Exception e) {

        }
    }
    
}
