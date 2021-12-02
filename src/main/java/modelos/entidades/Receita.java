/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.entidades;

import java.util.Date;

public class Receita {
    
    //Enumeration
    public enum Tipo {
        FIXA, ESPORADICA; 
    }
    
    private int id = 0;
    private String nome = "";
    private String descricao = "";
    private float valor = 0;
    private Date dataDaReceita;
    private Tipo tipo;
    private int iDContaCorrente;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataDaReceita() {
        return dataDaReceita;
    }

    public void setDataDaReceita(Date dataDaReceita) {
        this.dataDaReceita = dataDaReceita;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getiDContaCorrente() {
        return iDContaCorrente;
    }

    public void setiDContaCorrente(int iDContaCorrente) {
        this.iDContaCorrente = iDContaCorrente;
    }
    
}
