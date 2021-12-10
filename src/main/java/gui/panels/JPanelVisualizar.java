/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels;

import controle.ContaControle;
import controle.DespesaControle;
import controle.ReceitaControle;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.util.Date;
import jiconfont.icons.font_awesome.FontAwesome;
import modelos.entidades.Calcular;
import modelos.entidades.Conta;
import modelos.entidades.Despesa;
import modelos.entidades.Receita;
import util.TelaUtils;

/**
 *
 * @author galdi
 */
public class JPanelVisualizar extends javax.swing.JPanel {
    
    private DespesaControle despesaControl;
    private ReceitaControle receitaControl;
    private DefaultTableModel model;
    private JFrame parent;
    
    public JPanelVisualizar(JFrame parent) throws Exception {
        this.parent = parent;
        initComponents();
        despesaControl = new DespesaControle();
        receitaControl = new ReceitaControle();
        model = (DefaultTableModel) jTable.getModel();
        Date data = new Date();
        mostrarListagem(data);
        jXDatePickerMes.setFormats("MM/yyyy");
    }

    private void mostrarListagem(Date data) {
        try {
            Calcular calc = new Calcular();
            ContaControle contaControl = new ContaControle();
            ArrayList<Despesa> arrayDasDespesas;
            ArrayList<Receita> arrayDasReceitas;
            float receitaTotal = 0;
            float despesaTotal = 0;
            
            model.setNumRows(despesaControl.listagem().size() + receitaControl.listagem().size());
            int iLinha = 0;
            for (Conta conta : contaControl.listagem()) {
                arrayDasDespesas = despesaControl.listagem(data, conta);
                arrayDasReceitas = receitaControl.listagem(data, conta);
                SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
                
                receitaTotal += calc.getReceitasTotais(conta, data);
                despesaTotal += calc.getDespesasTotais(conta, data);
                
                for (int i = 0; i < arrayDasDespesas.size(); i++) {
                    Despesa despesa = arrayDasDespesas.get(i);
                    model.setValueAt(despesa.getNome() + " " + sdf.format(despesa.getDataDaReceita()) + " Conta:" +  contaControl.consultarPorID(
                            despesa.getIDContaCorrente()).getNumero(), i + iLinha, 0);
                }
                
                for (int i = 0; i < arrayDasReceitas.size(); i++) {
                    Receita receita = arrayDasReceitas.get(i);
                    model.setValueAt(receita.getNome() + " " + sdf.format(receita.getDataDaReceita()) + " Conta:" + contaControl.consultarPorID(
                            receita.getiDContaCorrente()).getNumero(), i + iLinha, 1);
                }
                iLinha++;
            }
            jLabelGastosTotais.setText(despesaTotal + "");
            jLabelReceitasTotais.setText(receitaTotal + "");
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jXDatePickerMes = new org.jdesktop.swingx.JXDatePicker();
        jButtonPesquisar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabelGastosTotais = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelReceitasTotais = new javax.swing.JLabel();

        jScrollPane2.setViewportView(jEditorPane1);

        setPreferredSize(new java.awt.Dimension(1041, 719));

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html><center>Visualizar<center></html>");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Despesas", "Receitas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setRowHeight(35);
        jTable.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(jTable);

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        jLabel2.setText("Mês:");

        jXDatePickerMes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButtonPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonPesquisar.setIcon(TelaUtils.getIconFontAwesome(FontAwesome.SEARCH, 16));
        jButtonPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel3.setText("Gastos Totais:");

        jLabelGastosTotais.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabelGastosTotais.setText("#");

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel4.setText("Receitas Totais:");

        jLabelReceitasTotais.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabelReceitasTotais.setText("#");

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
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXDatePickerMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelGastosTotais)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelReceitasTotais)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXDatePickerMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelGastosTotais))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelReceitasTotais)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        try {
            mostrarListagem(jXDatePickerMes.getDate());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelGastosTotais;
    private javax.swing.JLabel jLabelReceitasTotais;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerMes;
    // End of variables declaration//GEN-END:variables
}
