package modelos.interfaces;

import modelos.entidades.Conta;

import java.util.ArrayList;

public interface IContaDAO {
    void incluir(Conta objeto) throws Exception;
    void alterar(Conta objeto) throws Exception;
    void apagarPorID(int id) throws Exception;
    Conta consultarPorID(int id) throws Exception;
    ArrayList<Conta> listagem() throws Exception;
}
