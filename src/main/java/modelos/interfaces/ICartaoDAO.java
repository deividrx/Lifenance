package modelos.interfaces;

import modelos.entidades.Banco;
import modelos.entidades.Cartao;

import java.util.ArrayList;

public interface ICartaoDAO {
    void incluir(Cartao objeto) throws Exception;
    void alterar(Cartao objeto) throws Exception;
    Cartao consultarPorID(int id) throws Exception;
    ArrayList<Cartao> listagem() throws Exception;
    void apagarPorId (int id) throws Exception;
}
