package application;

import persistencia.Config;
import gui.TelaPrincipal;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import util.TelaUtils;

public class Application {
    
    public static void main(String[] args) {
        try {
            Config config = new Config();
            
            if (config.getProperties().isEmpty() == true) {
                config.createDefaultConfigFile();
            }
            
            UIManager.setLookAndFeel(TelaUtils.getLookAndFeel(config.getProperties().getProperty("LookAndFeel")));
            System.setProperty("sun.java2d.uiScale", TelaUtils.getUiSizeNumber(config.getProperties().getProperty("UiSize")));
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        
        // Create and display the form
        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }
    
}
