/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import modelos.entidades.Receita;
import modelos.entidades.enums.TipoReceita;

/**
 *
 * @author galdi
 */
public class Teste {
     public static void main(String[] args) {
        Receita receita = new Receita();
        receita.setTipo(TipoReceita.FIXA);
        receita.setNome("Salário");
        
        String saida = "Receita: " + receita.getNome() + " Tipo:"+ receita.getTipo();
        
        System.out.println(saida);
        
    }
}
