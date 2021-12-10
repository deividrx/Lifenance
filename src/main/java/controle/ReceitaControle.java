/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import java.util.Date;
import modelos.entidades.Conta;
import modelos.entidades.Receita;
import modelos.entidades.enums.TipoReceita;
import modelos.interfaces.IReceitaDAO;
import persistencia.ReceitaDAO;

/**
 *
 * @author galdi
 */
public class ReceitaControle implements IReceitaDAO {
    
    private ReceitaDAO receita;

    public ReceitaControle() throws Exception {
        receita = new ReceitaDAO("Receita.txt");
    }
    
    @Override
    public void incluir(Receita objeto) throws Exception {
        if (receita.consultarPorID(objeto.getId()) == null) {
            receita.incluir(objeto);
        } else {
            throw new Exception("Receita j√° cadastrada!");
        }
    }

    @Override
    public void alterar(Receita objeto) throws Exception {
        if (consultarPorID(objeto.getId()) == null) throw new Exception("Alterar o Id da Receita n„o È permitido!");
        receita.alterar(objeto);
    }

    @Override
    public void apagarPorID(int id) throws Exception {
        receita.apagarPorID(id);
    }

    @Override
    public Receita consultarPorID(int id) throws Exception {
        return receita.consultarPorID(id);
    }

    @Override
    public ArrayList<Receita> listagem() throws Exception {
       return receita.listagem();
    }
    
    public ArrayList<Receita> listagem(Date data, Conta conta) throws Exception {
        if(data == null) throw new Exception("Data inv·lida!");
        if(conta == null) throw new Exception("Conta inv·lida!");
        ArrayList<Receita> receitas = listagem();
        ArrayList<Receita> achados = new ArrayList<>();
        for (int i = 0; i < receitas.size(); i++) {
            Receita aux = receitas.get(i);
            
            if (aux.getTipo() == TipoReceita.FIXA && aux.getiDContaCorrente() == conta.getId())
                achados.add(aux);
            else if (aux.getiDContaCorrente() == conta.getId() && aux.getDataDaReceita().getMonth() == data.getMonth() 
                        && aux.getDataDaReceita().getYear() == data.getYear()) {
                    achados.add(aux);
            }
            
        }
        return achados;
    }
}
