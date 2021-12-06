/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import modelos.entidades.Receita;
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
            throw new Exception("Receita já cadastrada!");
        }
    }

    @Override
    public void alterar(Receita objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apagarPorID(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Receita consultarPorID(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Receita> listagem() throws Exception {
       return receita.listagem();
    }
    
}
