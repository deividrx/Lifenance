package gui.jdialog;

import gui.TelaPrincipal;
import persistencia.Config;
import javax.swing.*;
import util.TelaUtils;
import java.util.Properties;

public class JDialogTelaConfig extends javax.swing.JDialog {
    
    private Properties propriedades;
    private Config config;
    private final TelaPrincipal tela;
    private String temaSelecionado = "FlatLaf Dark";

    public JDialogTelaConfig(TelaPrincipal tela, boolean modal) throws Exception {
        super(tela, modal);
        this.tela = tela;
        initComponents();
        config = new Config();
        propriedades = config.getProperties();
        jComboBoxTemas.setSelectedItem(propriedades.get("LookAndFeel"));
        jComboBoxSize.setSelectedItem(propriedades.get("UiSize"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxTemas = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxSize = new javax.swing.JComboBox<>();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurações");
        setResizable(false);

        jComboBoxTemas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxTemas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FlatLaf Dark", "FlatLaf Light", "Nord", "Dracula", "Spacegray", "One Dark", "Gruvbox Dark Soft", "Solarized Light" }));
        jComboBoxTemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTemasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel3.setText("Tema da Interface:");

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel4.setText("Tamanho da Interface:");

        jComboBoxSize.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Grande", "Extra Grande" }));
        jComboBoxSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSizeActionPerformed(evt);
            }
        });

        jButtonConfirmar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setText("<html><b>Aviso: </b>É necessário reiniciar o programa para aplicar a mudança<br> de tamanho de tela.<br></html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxTemas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonConfirmar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 53, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancelar, jButtonConfirmar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTemas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConfirmar)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jComboBoxTemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTemasActionPerformed
       temaSelecionado = jComboBoxTemas.getSelectedItem().toString();
    }//GEN-LAST:event_jComboBoxTemasActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        try {
           tela.setLookAndFeel(TelaUtils.getLookAndFeel(temaSelecionado));
           this.dispose();
           propriedades.put("LookAndFeel", temaSelecionado);
           config.salvarProperties(propriedades);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jComboBoxSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSizeActionPerformed
        try {
            propriedades.put("UiSize", jComboBoxSize.getSelectedItem().toString());
            config.salvarProperties(propriedades);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE); 
        }
    }//GEN-LAST:event_jComboBoxSizeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JComboBox<String> jComboBoxSize;
    private javax.swing.JComboBox<String> jComboBoxTemas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
