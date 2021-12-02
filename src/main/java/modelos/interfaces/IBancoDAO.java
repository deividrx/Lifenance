
package modelos.interfaces;
import modelos.entidades.Banco;
import java.util.ArrayList;

public interface IBancoDAO {
    void incluir(Banco objeto) throws Exception;
    void alterar(Banco objeto) throws Exception;
    void apagarPorID(int id) throws Exception;
    Banco consultarPorID(int id) throws Exception;
    ArrayList<Banco> listagem() throws Exception;
}

