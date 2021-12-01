package persistencia;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Config {
    
    private final DataFiles file;

    public Config() throws Exception {
        file = new DataFiles("config.properties");
    }
    
    public void salvarProperties(Properties config) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getFile(), false))) {
            config.store(bw, null);
        } catch (IOException erro) {
            throw new Exception("Não foi possivel salvar as propriedades!");
        }
    }
    
    public Properties getProperties() {
        try (BufferedReader br = new BufferedReader(new FileReader(file.getFile()))) {
            Properties config = new Properties();
            config.load(br);
            return config;
        } catch (IOException e) {
            return null;
        }
    }
    
    public void createDefaultConfigFile() throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file.getFile(), false))) {
            Properties config = new Properties();
            config.setProperty("LookAndFeel", "FlatLaf Light");
            config.setProperty("UiSize", "Normal");
            config.store(bw, null);
        } catch (IOException erro) {
            throw new Exception("Não foi possivel Criar as propriedades!");
        }
    }
     
}
