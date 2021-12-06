/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import modelos.entidades.Conta;
import modelos.interfaces.IContaDAO;
import persistencia.ContaDAO;

/**
 *
 * @author galdi
 */
public class ContaControle implements IContaDAO {
    
    private ContaDAO contaDAO;

    public ContaControle() throws Exception {
        contaDAO = new ContaDAO("Contas.txt");
    }
    
    @Override
    public void incluir(Conta objeto) throws Exception {
        if (contaDAO.consultarPorID(objeto.getId()) == null)
            contaDAO.incluir(objeto);
        else
            throw new Exception("Está conta já está cadastrada!");
    }

    @Override
    public void alterar(Conta objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apagarPorID(int id) throws Exception {
        contaDAO.apagarPorID(id);
    }

    @Override
    public Conta consultarPorID(int id) throws Exception {
        return contaDAO.consultarPorID(id);
    }

    @Override
    public ArrayList<Conta> listagem() throws Exception {
        return contaDAO.listagem();
   }

}
