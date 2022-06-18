package application;

import org.webjars.WebJarAssetLocator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public class Test {
    public static void main(String[] args) {

        try {


            System.out.println(LocalTime.now().getHour());

            // WebJarAssetLocator locator = new WebJarAssetLocator();
            // Set<String> fullPathsOfAssets = locator.listAssets("/");
            // System.out.println(fullPathsOfAssets);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
