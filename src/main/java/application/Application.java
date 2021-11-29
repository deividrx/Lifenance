package application;

import gui.TelaPrincipal;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import util.TelaUtils;


public class Application {
    
    private static Properties configuracoes;
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(TelaUtils.getLookAndFeel(Config.getProperties().getProperty("LookAndFeel")));
        } catch (UnsupportedLookAndFeelException erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        // Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
}
