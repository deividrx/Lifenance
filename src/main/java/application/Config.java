 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author galdi
 */
public class Config {
    
    public static void salvarProperties(Properties config) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./src/main/java/resources/config.properties", false))) {
            config.store(bw, null);
        } catch (IOException erro) {
            throw new Exception("Não foi possivel salvar as propriedades!");
        }
    }
    
    public static Properties getProperties() {
        try (BufferedReader br = new BufferedReader(new FileReader("./src/main/java/resources/config.properties"))) {
            Properties config = new Properties();
            config.load(br);
            return config;
        } catch (IOException e) {
            return null;
        }
    }
    
}
