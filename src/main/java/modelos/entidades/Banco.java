/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.entidades;
/**
 *
 * @author galdi
 */
public class Banco {
    //Atributos
    private int id = 0; 
    private String descricao = "";
    
    //Metodos
    public Banco() {}
    
    public Banco(int id, String descricao) { 
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return id + ";" + descricao;
    }  
}
