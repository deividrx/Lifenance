package controle;

import java.util.ArrayList;
import modelos.entidades.Cartao;
import modelos.interfaces.ICartaoDAO;
import persistencia.CartaoDAO;


public class CartaoControle implements ICartaoDAO {

    private final CartaoDAO cartaoDAO;

    public CartaoControle() throws Exception {
        cartaoDAO = new CartaoDAO("Cartaos.txt");
    }

    @Override
    public void incluir(Cartao objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Cartao objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cartao consultarPorID(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cartao> listagem() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void apagarPorId(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
