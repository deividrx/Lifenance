/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.entidades;

import controle.DespesaControle;
import controle.ReceitaControle;
import java.util.Date;

/**
 *
 * @author galdi
 */
public class Calcular {
    
    public float getDespesasTotais(Conta conta, Date data) throws Exception {
        DespesaControle dc = new DespesaControle();
        float soma = 0;
        for (Despesa despesa : dc.listagem(data,conta)) {
            soma += despesa.getValor();
        }
        return soma;
    }
    
    public float getReceitasTotais(Conta conta, Date data) throws Exception {
        ReceitaControle rc = new ReceitaControle();
        float soma = 0;
        for (Receita receita : rc.listagem(data,conta)) {
            soma += receita.getValor();
        }
        return soma;
    }
    
    public float calcularSaldoDisponivel(Conta conta, Date data) throws Exception {
         float saldo = conta.getSaldo() + getReceitasTotais(conta,data) - getDespesasTotais(conta,data);
         conta.setSaldo(saldo);
         return saldo;
    }
    
    //public boolean avisoDeLimite(Cartão card) {
    //    if (card.get)
    //}
}
