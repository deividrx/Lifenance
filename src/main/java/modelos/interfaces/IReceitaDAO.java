/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.interfaces;

import java.util.ArrayList;
import modelos.entidades.Receita;

public interface IReceitaDAO {
    void incluir(Receita objeto) throws Exception;
    void alterar(Receita objeto) throws Exception;
    void apagarPorID(int id) throws Exception;
    Receita consultarPorID(int id) throws Exception;
    ArrayList<Receita> listagem() throws Exception;
}
