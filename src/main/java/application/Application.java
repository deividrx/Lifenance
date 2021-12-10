package application;

import persistencia.Config;
import gui.TelaPrincipal;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import util.TelaUtils;

import java.util.Objects;

public class Application {
    
    public static void main(String[] args) {
        try {
            Config config = new Config();
            
            if (config.getProperties().isEmpty()) {
                config.createDefaultConfigFile();
            }
            
            System.setProperty("sun.java2d.uiScale", Objects.requireNonNull(TelaUtils.getUiSizeNumber(config.getProperties().getProperty("UiSize"))));
            UIManager.setLookAndFeel(TelaUtils.getLookAndFeel(config.getProperties().getProperty("LookAndFeel")));
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        
        // Create and display the form
        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }
    
}
