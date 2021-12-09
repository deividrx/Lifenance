/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import modelos.entidades.enums.TipoReceita;

public class Receita {

    private int id = 0;
    private String nome = "";
    private String descricao = "";
    private float valor = 0;
    private Date dataDaReceita;
    private TipoReceita tipo;
    private int IDContaCorrente;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Receita() {
    }
    
    public Receita(int id, String nome, String descricao, float valor,Date dataDaReceita, TipoReceita tipo, int IDContaCorrente) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.dataDaReceita = dataDaReceita;
        this.tipo = tipo;
        this.IDContaCorrente = IDContaCorrente;
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

    public TipoReceita getTipo() {
        return tipo;
    }

    public void setTipo(TipoReceita tipo) {
        this.tipo = tipo;
    }

    public int getiDContaCorrente() {
        return IDContaCorrente;
    }

    public void setiDContaCorrente(int iDContaCorrente) {
        this.IDContaCorrente = iDContaCorrente;
    }

    @Override
    public String toString() {
       return id + ";" + nome + ";" + descricao + ";" + valor + ";" + sdf.format(dataDaReceita) + ";" + tipo + ";" + IDContaCorrente;
    }
}
