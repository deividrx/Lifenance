/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.interfaces;

import java.util.ArrayList;

import modelos.entidades.Cartao;
import modelos.entidades.Despesa;

/**
 *
 * @author galdi
 */
public interface IDespesaDAO {
    void incluir(Despesa objeto) throws Exception;
    void alterar(Despesa objeto) throws Exception;
    void apagarPorID(int id) throws Exception;
    Despesa consultarPorID(int id) throws Exception;
    ArrayList<Despesa> listagem() throws Exception;
}
