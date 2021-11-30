package application;

import gui.TelaPrincipal;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import util.TelaUtils;


public class Application {
    
    public static void main(String[] args) {
        
        File file = new File("");
        System.out.println(file.getAbsolutePath());

        //Set Ui size
        System.setProperty("sun.java2d.uiScale", TelaUtils.getUiSizeNumber(Config.getProperties().getProperty("UiSize")));
        // Set look and Feel
        try {
            UIManager.setLookAndFeel(TelaUtils.getLookAndFeel(Config.getProperties().getProperty("LookAndFeel")));
        } catch (UnsupportedLookAndFeelException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        // Create and display the form
        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }
    
}
