/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import java.util.Date;
import models.Conta;
import models.Despesa;
import models.enums.TipoDespesa;

/**
 *
 * @author galdi
 */
public class DespesaControle {

//    //private final DespesDAO objDespesaDao;
//
//    public DespesaControle() throws Exception {
//        //objDespesaDao = new DespesDAO("Despesa.txt");
//    }
//
//    //@Override
//    public void incluir(Despesa objeto) throws Exception {
//        //Despesa aux = objDespesaDao.consultarPorID(objeto.getId());
//       // if (aux == null) {
//            //objDespesaDao.incluir(objeto);
//       // } else {
//            throw new Exception("Despesa j? cadastrado!");
//       // }
//
//
//    }
//
//    //@Override
//    public void alterar(Despesa objeto) throws Exception {
//        if (consultarPorID(objeto.getId()) == null) throw new Exception("Alterar o Id da Despesa n�o � permitido!");
//        objDespesaDao.alterar(objeto);
//    }
//
//   // @Override
//    public void apagarPorID(int id) throws Exception {
//        objDespesaDao.apagarPorID(id);
//    }
//
//    //@Override
//    public Despesa consultarPorID(int id) throws Exception {
//        return objDespesaDao.consultarPorID(id);
//    }
//
//    //@Override
//    public ArrayList<Despesa> listagem() throws Exception {
//        return objDespesaDao.listagem();
//    }
//
//    public ArrayList<Despesa> listagem(Date data, Conta conta) throws Exception {
//        if(data == null) throw new Exception("Data inv�lida!");
//        if(conta == null) throw new Exception("Conta inv�lida!");
//        ArrayList<Despesa> despesas = listagem();
//        ArrayList<Despesa> achados = new ArrayList<>();
//        for (int i = 0; i < despesas.size(); i++) {
//            Despesa aux = despesas.get(i);
//
//            if (aux.getTipo() == TipoDespesa.FIXA && aux.getIDContaCorrente() == conta.getId())
//                achados.add(aux);
//            else if (aux.getIDContaCorrente() == conta.getId() && aux.getDataDaReceita().getMonth() == data.getMonth()
//                        && aux.getDataDaReceita().getYear() == data.getYear()) {
//                    achados.add(aux);
//            }
//        }
//        return achados;
//    }
//
}
