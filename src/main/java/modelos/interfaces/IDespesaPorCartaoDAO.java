package modelos.interfaces;

import modelos.entidades.Despesa;
import modelos.entidades.DespesaPorCartao;

import java.util.ArrayList;

public interface IDespesaPorCartaoDAO {
    void incluir(DespesaPorCartao objeto) throws Exception;
    void alterar(DespesaPorCartao objeto) throws Exception;
    void apagarPorID(int id) throws Exception;
    Despesa consultarPorID(int id) throws Exception;
    ArrayList<DespesaPorCartao> listagem() throws Exception;
}
