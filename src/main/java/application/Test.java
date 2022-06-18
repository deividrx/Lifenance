package application;

import org.webjars.WebJarAssetLocator;

import java.util.Set;

public class Test {
    public static void main(String[] args) {

        try {
            WebJarAssetLocator locator = new WebJarAssetLocator();
            Set<String> fullPathsOfAssets = locator.listAssets("/");
            System.out.println(fullPathsOfAssets);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
