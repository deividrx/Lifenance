/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.interfaces;
import modelos.entidades.Banco;
import java.util.ArrayList;
/**
 *
 * @author galdi
 */
public interface IBancoDao {
    
    void incluir(Banco objeto) throws Exception;
    void alterar(Banco objeto) throws Exception;
    void apagarPorID(int id) throws Exception;
    Banco consultarPorID(int id) throws Exception;
    ArrayList<Banco> listagem() throws Exception;
    
}
