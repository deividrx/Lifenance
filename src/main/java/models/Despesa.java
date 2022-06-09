package models;

import java.time.LocalDate;

import models.annotations.ColumnName;
import models.annotations.PrimaryKey;

public class Despesa {

    @PrimaryKey("despesa_id")
    private long id;
    @ColumnName("despesa_name")
    private String nome;
    @ColumnName("description")
    private String description;
    @ColumnName("despesa_value")
    private float valor = 0;
    @ColumnName("despesa_date")
    private LocalDate dataDaReceita;
    @ColumnName("despesa_type")
    private String tipo;
    @ColumnName("conta_id")
    private Conta conta;

    public Despesa(Long id, String nome, String descricao, float valor, LocalDate dataDaReceita, String tipo, Conta conta) {
        this.id = id;
        this.nome = nome;
        this.description = descricao;
        this.valor = valor;
        this.dataDaReceita = dataDaReceita;
        this.tipo = tipo;
        this.conta = conta;
    }

    public Despesa(String arg) {
        String[] split = arg.split(";");
        this.id = Long.parseLong(split[0]);
        this.nome = split[1];
        this.description = split[2];
        this.valor = Float.parseFloat(split[3]);
        this.dataDaReceita = LocalDate.parse(split[4]);
        this.tipo = split[5];
        this.conta = ModelFactory.getModel(Conta.class, "contas", Long.parseLong(split[6]));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public LocalDate getDataDaReceita() {
        return dataDaReceita;
    }

    public void setDataDaReceita(LocalDate dataDaReceita) {
        this.dataDaReceita = dataDaReceita;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
