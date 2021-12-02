/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import modelos.entidades.Receita;

/**
 *
 * @author galdi
 */
public class Teste {
     public static void main(String[] args) {
        Receita receita = new Receita();
        receita.setTipo(Receita.Tipo.FIXA);
        System.out.println(receita.getTipo());
        
    }
}
