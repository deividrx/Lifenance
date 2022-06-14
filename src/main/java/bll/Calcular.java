package bll;

import controle.DespesaControle;
import controle.ReceitaControle;
import models.Account;

import java.util.Date;

public class Calcular {
    
    public float getDespesasTotais(Account account, Date data) throws Exception {
        DespesaControle dc = new DespesaControle();
        float soma = 0;
//        for (Despesa despesa : dc.listagem(data,conta)) {
//            soma += despesa.getValor();
//        }
        return soma;
    }
    
    public float getReceitasTotais(Account account, Date data) throws Exception {
        ReceitaControle rc = new ReceitaControle();
        float soma = 0;
        for (Receita receita : rc.listagem(data, account)) {
            soma += receita.getValor();
        }
        return soma;
    }
    
    public float calcularSaldoDisponivel(Account account, Date data) throws Exception {
         float saldo = account.getSaldo() + getReceitasTotais(account,data) - getDespesasTotais(account,data);
         account.setSaldo(saldo);
         return saldo;
    }
    
    //public boolean avisoDeLimite(Cart�o card) {
    //    if (card.get)
    //}
}
