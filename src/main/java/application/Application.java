package application;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Application {

    private static final Logger logger = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        try {
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(8888);
            tomcat.getConnector();

            String webapp = "src/main/webapp/";
            Context context = tomcat.addWebapp("/lifenance", new File(webapp).getAbsolutePath());

            File webInfClasses = new File("build/classes");
            WebResourceRoot resources = new StandardRoot(context);
            resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", webInfClasses.getAbsolutePath(), "/"));
            context.setResources(resources);

            tomcat.start();
            Desktop.getDesktop().browse(new URL("http://localhost:8888/lifenance").toURI());
            tomcat.getServer().await();

        } catch (LifecycleException | URISyntaxException | IOException error) {
            logger.fatal(error.getMessage());
        }
    }
    
}
