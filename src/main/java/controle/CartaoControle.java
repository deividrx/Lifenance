package controle;

import java.util.ArrayList;
import java.util.Date;
import modelos.entidades.Cartao;
import modelos.entidades.Conta;
import modelos.entidades.Despesa;
import modelos.interfaces.ICartaoDAO;
import persistencia.CartaoDAO;


public class CartaoControle implements ICartaoDAO {

    private final CartaoDAO cartaoDAO;

    public CartaoControle() throws Exception {
        cartaoDAO = new CartaoDAO("Cartaos.txt");
    }

    @Override
    public void incluir(Cartao objeto) throws Exception {
        if (cartaoDAO.consultarPorID(objeto.getId()) == null)
            cartaoDAO.incluir(objeto);
        else
            throw new Exception("Está conta já está cadastrada!");
    }

    @Override
    public void alterar(Cartao objeto) throws Exception {
        if (consultarPorID(objeto.getId()) == null) throw new Exception("Alterar o Id do Cartao não é permitido!");
        cartaoDAO.alterar(objeto);
    }

    @Override
    public Cartao consultarPorID(int id) throws Exception {
        return cartaoDAO.consultarPorID(id);
    }
    
    public Cartao consultarPorNumero(Long num) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cartao> listagem() throws Exception {
        return cartaoDAO.listagem();
    }

    @Override
    public void apagarPorId(int id) throws Exception {
        cartaoDAO.apagarPorId(id);
    }
    
}
