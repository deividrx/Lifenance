package controle;
import java.util.ArrayList;
import modelos.entidades.Banco;
import persistencia.BancoDao;
import modelos.interfaces.IBancoDAO;

public class BancoControle implements IBancoDAO{
    
    private final BancoDao objBancoDao;

    public BancoControle() throws Exception {
        objBancoDao = new BancoDao("Banco.txt");
    }
       
    @Override
    public void incluir(Banco objeto) throws Exception {
        Banco aux = objBancoDao.consultarPorID(objeto.getId());
        if (aux == null) {
            objBancoDao.incluir(objeto);
        } else {
            throw new Exception("Banco já cadastrado!");
        }
    }

    @Override
    public void alterar(Banco objeto) throws Exception {
        if (consultarPorID(objeto.getId()) == null) throw new Exception("Alterar o Id do Banco não é permitido!");
        objBancoDao.alterar(objeto);
    }

    @Override
    public void apagarPorID(int id) throws Exception {
        objBancoDao.apagarPorID(id);
    }

    @Override
    public Banco consultarPorID(int id) throws Exception {
       return objBancoDao.consultarPorID(id);
    }

    @Override
    public ArrayList<Banco> listagem() throws Exception {
         return objBancoDao.listagem();
    }
}
