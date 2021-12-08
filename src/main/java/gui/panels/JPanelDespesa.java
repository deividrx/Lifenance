/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels;

import controle.BancoControle;
import controle.ContaControle;
import controle.DespesaControle;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import gui.jdialog.JDialogBancoAlterar;
import gui.jdialog.JDialogBancoInserir;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumnModel;
import jiconfont.icons.font_awesome.FontAwesome;
import modelos.entidades.Conta;
import modelos.entidades.Despesa;
import util.TelaUtils;

/**
 *
 * @author galdi
 */
public class JPanelDespesa extends javax.swing.JPanel {
    
    private DespesaControle despesaControl;
    private DefaultTableModel model;
    private JFrame parent;
    
    private Conta contaSelecionada;
    private Date dataSelecionada;
    
    public JPanelDespesa(JFrame parent) throws Exception {
        despesaControl = new DespesaControle();
        this.parent = parent;
        initComponents();
        model = (DefaultTableModel) jTable.getModel();
        TableColumnModel tcm = (DefaultTableColumnModel) jTable.getColumnModel();
        tcm.removeColumn(tcm.getColumn(0));
        tcm.removeColumn(tcm.getColumn(5));
        ContaControle contaControl = new ContaControle();
        for (Conta conta : contaControl.listagem()) {
            String text = "Número: " + conta.getNumero() + " e Agencia: " + conta.getAgencia();
            jComboBox1.addItem(text);
        }
        jXDatePicker1.setFormats("MM/yyyy");
    }

    private void mostrarListagem(Date data, Conta conta) {
        try {
            ArrayList<Despesa> arrayDosBancos = despesaControl.listagem(data, conta);
            model = (DefaultTableModel) jTable.getModel();
            model.setNumRows(0);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            for (int i = 0; i < arrayDosBancos.size(); i++) {
                String[] saida = new String[2];
                Despesa aux = arrayDosBancos.get(i);
                saida[0] = aux.getId() + "";
                saida[1] = aux.getNome();
                saida[2] = Float.toString(aux.getValor());
                saida[3] = sdf.format(aux.getDataDaReceita());
                saida[4] = aux.getTipo().toString().toLowerCase();
                saida[5] = aux.getDescricao();
                saida[6] = Integer.toString(aux.getIDContaCorrente());
                model.addRow(saida);
            }
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItemEditar = new javax.swing.JMenuItem();
        jMenuItemExcluir = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButtonNovoBanco = new javax.swing.JButton();
        jButtonPesquisar = new javax.swing.JButton();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        jMenuItemEditar.setText("Editar Banco");
        jMenuItemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditarActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItemEditar);

        jMenuItemExcluir.setText("Excluir Banco");
        jMenuItemExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExcluirActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItemExcluir);

        jScrollPane2.setViewportView(jEditorPane1);

        setPreferredSize(new java.awt.Dimension(1041, 719));

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html><center>Despesa<center></html>");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Valor", "Data", "Tipo", "Descrição", "ID Conta Corrente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setRowHeight(35);
        jTable.setShowHorizontalLines(true);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jButtonNovoBanco.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButtonNovoBanco.setIcon(TelaUtils.getIconFontAwesome(FontAwesome.PLUS, 16)
        );
        jButtonNovoBanco.setText("Criar despesa");
        jButtonNovoBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoBancoActionPerformed(evt);
            }
        });

        jButtonPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonPesquisar.setIcon(TelaUtils.getIconFontAwesome(FontAwesome.SEARCH, 16));
        jButtonPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jXDatePicker1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel2.setText("Mês:");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel3.setText("Conta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGap(348, 348, 348)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                .addGap(348, 348, 348))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonNovoBanco))
                    .addComponent(jScrollPane1))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonNovoBanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoBancoActionPerformed
        try {
            JDialogBancoInserir addBanco = new JDialogBancoInserir(parent, true);
            addBanco.setVisible(true);
            //mostrarListagem();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonNovoBancoActionPerformed

    private void jMenuItemExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExcluirActionPerformed
          try {
            //objBancoControle.apagarPorID(Integer.parseInt(model.getValueAt(jTable.getSelectedRow(), 0).toString()));
            //mostrarListagem();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemExcluirActionPerformed

    private void jTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseReleased
        if (evt.isPopupTrigger() && jTable.isFocusOwner()) {
            jPopupMenu2.show(jTable,evt.getX(),evt.getY());
        }

    }//GEN-LAST:event_jTableMouseReleased

    private void jMenuItemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditarActionPerformed
        try {
            JDialogBancoAlterar addBanco = new JDialogBancoAlterar(parent, true, jTable.getValueAt(jTable.getSelectedRow(), 0).toString());
            addBanco.setVisible(true);
            //mostrarListagem();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemEditarActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        try {
            ContaControle conta = new ContaControle();
            dataSelecionada = jXDatePicker1.getDate();
            contaSelecionada = conta.listagem().get(jComboBox1.getSelectedIndex());
            mostrarListagem(dataSelecionada, contaSelecionada);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonNovoBanco;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItemEditar;
    private javax.swing.JMenuItem jMenuItemExcluir;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    // End of variables declaration//GEN-END:variables
}
