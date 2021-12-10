package gui;

import gui.jdialog.JDialogExportar;
import gui.jdialog.JDialogSobre;
import gui.jdialog.JDialogTelaConfig;
import gui.panels.*;
import java.awt.CardLayout;
import javax.swing.*;
import jiconfont.icons.font_awesome.FontAwesome;
import util.TelaUtils;

public class TelaPrincipal extends javax.swing.JFrame {
    //Atributos
    private final CardLayout panelPrincipal;

    //Creates new form TelaPrincipal
    public TelaPrincipal() {
        initComponents();
        panelPrincipal = (CardLayout) jPanelPrincipal.getLayout();
        jMenuExportar.setIcon(TelaUtils.getIconFontAwesome(FontAwesome.EXTERNAL_LINK_SQUARE, 16));
        
    }
    
    public void setLookAndFeel(LookAndFeel tema) {
        try {
            UIManager.setLookAndFeel(tema);
            SwingUtilities.updateComponentTreeUI(this);
            this.pack();
            jLabelLogo.setIcon(TelaUtils.getIconFontAwesome(FontAwesome.BOOK, 42)); 
        } catch (UnsupportedLookAndFeelException erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMenuPrincipal = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jButtonConfig = new javax.swing.JButton();
        jButtonCartao = new javax.swing.JButton();
        jButtonDespesa = new javax.swing.JButton();
        jButtonReceita = new javax.swing.JButton();
        jButtonBanco = new javax.swing.JButton();
        jButtonConta = new javax.swing.JButton();
        jButtonConta1 = new javax.swing.JButton();
        jPanelPrincipal = new javax.swing.JPanel();
        jPanelTelaPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jXImageView2 = new org.jdesktop.swingx.JXImageView();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuExportar = new javax.swing.JMenu();
        jMenuSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Lifenance");
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

        jLabelLogo.setFont(new java.awt.Font("Montserrat", 1, 25)); // NOI18N
        jLabelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogo.setIcon(TelaUtils.getIconFontAwesome(FontAwesome.BOOK, 42));
        jLabelLogo.setText("Lifenance");
        jLabelLogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelLogo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabelLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLogoMouseClicked(evt);
            }
        });

        jButtonConfig.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jButtonConfig.setText("Configuração");
        jButtonConfig.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfigActionPerformed(evt);
            }
        });

        jButtonCartao.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jButtonCartao.setText("Registrar cartão");
        jButtonCartao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCartao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCartaoActionPerformed(evt);
            }
        });

        jButtonDespesa.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jButtonDespesa.setText("<html><center>Registrar<br> Despesa</br><cemter></html>");
        jButtonDespesa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDespesaActionPerformed(evt);
            }
        });

        jButtonReceita.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jButtonReceita.setText("<html><center>Registrar<br>Receita</br><center></html>");
        jButtonReceita.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonReceita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReceitaActionPerformed(evt);
            }
        });

        jButtonBanco.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jButtonBanco.setText("<html><center>Registrar<br>Banco</br><center></html>");
        jButtonBanco.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBancoActionPerformed(evt);
            }
        });

        jButtonConta.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jButtonConta.setText("<html><center>Registrar<br>Conta</br><center></html>");
        jButtonConta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContaActionPerformed(evt);
            }
        });

        jButtonConta1.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jButtonConta1.setText("Visualizar");
        jButtonConta1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonConta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConta1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuPrincipalLayout = new javax.swing.GroupLayout(jPanelMenuPrincipal);
        jPanelMenuPrincipal.setLayout(jPanelMenuPrincipalLayout);
        jPanelMenuPrincipalLayout.setHorizontalGroup(
            jPanelMenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuPrincipalLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanelMenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCartao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDespesa)
                    .addComponent(jButtonReceita)
                    .addComponent(jButtonBanco)
                    .addComponent(jButtonConta)
                    .addComponent(jButtonConta1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanelMenuPrincipalLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonBanco, jButtonCartao, jButtonConfig, jButtonDespesa, jButtonReceita});

        jPanelMenuPrincipalLayout.setVerticalGroup(
            jPanelMenuPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuPrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonReceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonConta1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanelMenuPrincipalLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonBanco, jButtonCartao, jButtonConfig, jButtonDespesa, jButtonReceita});

        jPanelMenuPrincipalLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonConta, jButtonConta1});

        jPanelPrincipal.setLayout(new java.awt.CardLayout());

        jPanelTelaPrincipal.setLayout(new javax.swing.OverlayLayout(jPanelTelaPrincipal));

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 36)); // NOI18N
        jLabel1.setText("Bem-Vindo ao Lifenance");
        jLabel1.setAlignmentX(0.5F);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanelTelaPrincipal.add(jLabel1);

        jXImageView2.setAlpha(0.5F);
        jXImageView2.setEditable(false);
        try {
            jXImageView2.setImageURL(new java.net.URL("https://images.unsplash.com/photo-1561414927-6d86591d0c4f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1073&q=80"));
        } catch (java.io.IOException e1) {
            e1.printStackTrace();
        }

        javax.swing.GroupLayout jXImageView2Layout = new javax.swing.GroupLayout(jXImageView2);
        jXImageView2.setLayout(jXImageView2Layout);
        jXImageView2Layout.setHorizontalGroup(
            jXImageView2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1040, Short.MAX_VALUE)
        );
        jXImageView2Layout.setVerticalGroup(
            jXImageView2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 719, Short.MAX_VALUE)
        );

        jPanelTelaPrincipal.add(jXImageView2);

        jPanelPrincipal.add(jPanelTelaPrincipal, "telaPrincipal");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jMenu1.setText("Arquivo");

        jMenuExportar.setText("Exportar gastos");
        jMenuExportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuExportarMouseClicked(evt);
            }
        });
        jMenu1.add(jMenuExportar);

        jMenuBar1.add(jMenu1);

        jMenuSobre.setText("Sobre");
        jMenuSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSobreMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuSobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMenuPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogoMouseClicked
        try {
            panelPrincipal.show(jPanelPrincipal, "telaPrincipal");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jLabelLogoMouseClicked

    private void jButtonConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfigActionPerformed
        try {
            JDialogTelaConfig telaConfig = new JDialogTelaConfig(this, true);
            telaConfig.setVisible(true);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonConfigActionPerformed

    private void jButtonBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBancoActionPerformed
        try {
            JPanelBanco banco = new JPanelBanco(this);
            jPanelPrincipal.add(banco, "telaBanco");
            panelPrincipal.show(jPanelPrincipal, "telaBanco");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonBancoActionPerformed

    private void jButtonCartaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCartaoActionPerformed
       try {
            JPanelCartao cartao = new JPanelCartao(this);
            jPanelPrincipal.add(cartao, "telaCartao");
            panelPrincipal.show(jPanelPrincipal, "telaCartao");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCartaoActionPerformed

    private void jButtonContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContaActionPerformed
        try {
            JPanelConta conta = new JPanelConta(this);
            jPanelPrincipal.add(conta, "telaConta");
            panelPrincipal.show(jPanelPrincipal, "telaConta");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonContaActionPerformed

    private void jButtonDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDespesaActionPerformed
        try {
            JPanelDespesa despesa = new JPanelDespesa(this);
            jPanelPrincipal.add(despesa, "telaDespesa");
            panelPrincipal.show(jPanelPrincipal, "telaDespesa");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDespesaActionPerformed

    private void jButtonReceitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReceitaActionPerformed
        try {
            JPanelReceita despesa = new JPanelReceita(this);
            jPanelPrincipal.add(despesa, "telaReceita");
            panelPrincipal.show(jPanelPrincipal, "telaReceita");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonReceitaActionPerformed

    private void jButtonConta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConta1ActionPerformed
        try {
            JPanelVisualizar view = new JPanelVisualizar(this);
            jPanelPrincipal.add(view, "telaV");
            panelPrincipal.show(jPanelPrincipal, "telaV");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonConta1ActionPerformed

    private void jMenuExportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuExportarMouseClicked
        try {
            JDialogExportar export = new JDialogExportar(this, true);
            export.setVisible(true);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuExportarMouseClicked

    private void jMenuSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSobreMouseClicked
        try {
            JDialogSobre about = new JDialogSobre(this, true);
            about.setVisible(true);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuSobreMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBanco;
    private javax.swing.JButton jButtonCartao;
    private javax.swing.JButton jButtonConfig;
    private javax.swing.JButton jButtonConta;
    private javax.swing.JButton jButtonConta1;
    private javax.swing.JButton jButtonDespesa;
    private javax.swing.JButton jButtonReceita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuExportar;
    private javax.swing.JMenu jMenuSobre;
    private javax.swing.JPanel jPanelMenuPrincipal;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelTelaPrincipal;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXImageView jXImageView2;
    // End of variables declaration//GEN-END:variables
}
