package controle;

import java.util.ArrayList;

import models.Card;
import modelos.interfaces.ICartaoDAO;
import persistencia.CartaoDAO;


public class CartaoControle implements ICartaoDAO {

    private final CartaoDAO cartaoDAO;

    public CartaoControle() throws Exception {
        cartaoDAO = new CartaoDAO("Cartaos.txt");
    }

    @Override
    public void incluir(Card objeto) throws Exception {
        if (cartaoDAO.consultarPorID(objeto.getId()) == null)
            cartaoDAO.incluir(objeto);
        else
            throw new Exception("Est� conta j� est� cadastrada!");
    }

    @Override
    public void alterar(Card objeto) throws Exception {
        cartaoDAO.alterar(objeto);
    }

    @Override
    public Card consultarPorID(int id) throws Exception {
        return cartaoDAO.consultarPorID(id);
    }
    
    public Card consultarPorNumero(Long num) throws Exception {
        for (Card card : listagem()) {
            if (card.getNumero() == num)
                return card;
        }
        return null;
    }

    @Override
    public ArrayList<Card> listagem() throws Exception {
        return cartaoDAO.listagem();
    }

    @Override
    public void apagarPorId(int id) throws Exception {
        cartaoDAO.apagarPorId(id);
    }
    
}
