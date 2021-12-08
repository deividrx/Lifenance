/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.entidades;

import controle.DespesaControle;
import controle.ReceitaControle;

/**
 *
 * @author galdi
 */
public class Calcular {
    
    public float getDespesasTotais() throws Exception {
        DespesaControle dc = new DespesaControle();
        float soma = 0;
        for (Despesa despesa : dc.listagem()) {
            soma += despesa.getValor();
        }
        return soma;
    }
    
    public float getReceitasTotais() throws Exception {
        ReceitaControle rc = new ReceitaControle();
        float soma = 0;
        for (Receita receita : rc.listagem()) {
            soma += receita.getValor();
        }
        return soma;
    }
    
    public float calcularSaldoDisponivel(Conta conta) throws Exception {
         return conta.getSaldo() + getReceitasTotais() - getDespesasTotais();
    }
    
    //public boolean avisoDeLimite(Cartão card) {
    //    if (card.get)
    //}
}
