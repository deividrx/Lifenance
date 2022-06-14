package models;

import models.annotations.ColumnName;
import models.annotations.PrimaryKey;
import models.enumeration.AccountType;

public class Account {

    @PrimaryKey("id_account")
    private Long id;
    @ColumnName("account_number")
    private int numero;
    @ColumnName("agencia")
    private int agencia;
    @ColumnName("account_type")
    private AccountType tipo;
    @ColumnName("limite")
    private float limite;
    @ColumnName("saldo")
    private float saldo;
    @ColumnName("bank_name")
    private String banco;
    @ColumnName("user_id")
    private User user;

    public Account(Long id, int numero, int agencia, AccountType tipo, float limite, float saldo,
                   String banco, User user) {
        this.id = id;
        this.numero = numero;
        this.agencia = agencia;
        this.tipo = tipo;
        this.limite = limite;
        this.saldo = saldo;
        this.banco = banco;
        this.user = user;
    }

    // Constructor for genericDAO
    public Account(String arg) {
        String[] split = arg.split(";");
        this.id = Long.parseLong(split[0]);
        this.numero = Integer.parseInt(split[1]);
        this.agencia = Integer.parseInt(split[2]);
        this.tipo = AccountType.valueOf(split[3]);
        this.limite = Float.parseFloat(split[4]);
        this.saldo = Float.parseFloat(split[5]);
        this.banco = split[6];
        this.user = ModelFactory.getModel(User.class, "users", Long.parseLong(split[9]));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public AccountType getTipo() {
        return tipo;
    }

    public void setTipo(AccountType tipo) {
        this.tipo = tipo;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
}
