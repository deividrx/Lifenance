/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;
import java.util.ArrayList;
import modelos.entidades.Banco;
import modelos.interfaces.IBancoDao;
import persistencia.BancoDao;
/**
 *
 * @author galdi
 */
public class BancoControle implements IBancoDao{
    
    private BancoDao objBancoDao = new BancoDao("./ArquivosDeDados/Banco.txt");
    
    
    @Override
    public void incluir(Banco objeto) throws Exception {
        try {
            
            Banco aux = objBancoDao.consultarPorID(objeto.getId());
            if (aux == null) {
                objBancoDao.incluir(objeto);
            } else {
                throw new Exception("Banco já cadastrado!");
            }
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterar(Banco objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
