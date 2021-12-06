package controle;
import java.util.ArrayList;
import modelos.entidades.Banco;
import persistencia.BancoDAO;
import modelos.interfaces.IBancoDAO;

public class BancoControle implements IBancoDAO{
    
    private final BancoDAO objBancoDAO;

    public BancoControle() throws Exception {
        objBancoDAO = new BancoDAO("Banco.txt");
    }
       
    @Override
    public void incluir(Banco objeto) throws Exception {
        Banco aux = objBancoDAO.consultarPorID(objeto.getId());
        if (aux == null) {
            objBancoDAO.incluir(objeto);
        } else {
            throw new Exception("Banco j� cadastrado!");
        }
    }

    @Override
    public void alterar(Banco objeto) throws Exception {
        if (consultarPorID(objeto.getId()) == null) throw new Exception("Alterar o Id do Banco não é permitido!");
        objBancoDAO.alterar(objeto);
    }

    @Override
    public void apagarPorID(int id) throws Exception {
        objBancoDAO.apagarPorID(id);
    }

    @Override
    public Banco consultarPorID(int id) throws Exception {
       return objBancoDAO.consultarPorID(id);
    }

    @Override
    public ArrayList<Banco> listagem() throws Exception {
         return objBancoDAO.listagem();
    }
}
