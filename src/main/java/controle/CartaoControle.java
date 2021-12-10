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
        if (cartaoDAO.consultarPorID(objeto.getId()) == null)
            cartaoDAO.incluir(objeto);
        else
            throw new Exception("Está conta já está cadastrada!");
    }

    @Override
    public void alterar(Cartao objeto) throws Exception {
        cartaoDAO.alterar(objeto);
    }

    @Override
    public Cartao consultarPorID(int id) throws Exception {
        return cartaoDAO.consultarPorID(id);
    }
    
    public Cartao consultarPorNumero(Long num) throws Exception {
        for (Cartao card : listagem()) {
            if (card.getNumero() == num)
                return card;
        }
        return null;
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
