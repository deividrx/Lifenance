/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import modelos.entidades.enums.TipoDespesa;

/**
 *
 * @author galdi
 */
public class Despesa {
    
    private int id = 0;
    private String nome = "";
    private String descricao = "";
    private float valor = 0;
    private Date dataDaReceita;
    private TipoDespesa tipo;
    private int IDContaCorrente;
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyyy");
    
    public Despesa() {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.dataDaReceita = dataDaReceita;
        this.tipo = tipo;
        this.IDContaCorrente = IDContaCorrente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getDataDaReceita() {
        return dataDaReceita;
    }

    public void setDataDaReceita(Date dataDaReceita) {
        this.dataDaReceita = dataDaReceita;
    }

    public TipoDespesa getTipo() {
        return tipo;
    }

    public void setTipo(TipoDespesa tipo) {
        this.tipo = tipo;
    }

    public int getIDContaCorrente() {
        return IDContaCorrente;
    }

    public void setIDContaCorrente(int IDContaCorrente) {
        this.IDContaCorrente = IDContaCorrente;
    }

    @Override
    public String toString() {
        return id + ";" + nome + ";" + descricao + ";" + valor + ";" + format.format(dataDaReceita) + ";" + tipo + ";" + IDContaCorrente;
    }
 
}
