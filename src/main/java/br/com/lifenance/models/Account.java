package br.com.lifenance.models;

import br.com.lifenance.models.enumeration.AccountType;
import br.com.lifenance.models.annotations.ColumnName;
import br.com.lifenance.models.annotations.PrimaryKey;

public class Account {

    @PrimaryKey("bank_account_id")
    private Long id;
    @ColumnName("bank_name")
    private String banco;
    @ColumnName("agencia")
    private int agencia;
    @ColumnName("account_number")
    private int numero;
    @ColumnName("type_account")
    private AccountType tipo;
    @ColumnName("limite")
    private float limite;
    @ColumnName("user_cpf")
    private User user;

    public Account(int numero, int agencia, AccountType tipo, float limite, String banco, User user) {
        this.banco = banco;
        this.agencia = agencia;
        this.numero = numero;
        this.tipo = tipo;
        this.limite = limite;
        this.user = user;
    }

    public Account(long id, int numero, int agencia, AccountType tipo, float limite, String banco, User user) {
        this.id = id;
        this.banco = banco;
        this.agencia = agencia;
        this.numero = numero;
        this.tipo = tipo;
        this.limite = limite;
        this.user = user;
    }

    // Constructor for genericDAO
    public Account(String arg) {
        String[] split = arg.split(";");
        this.id = Long.parseLong(split[0]);
        this.banco = split[1];
        this.agencia = Integer.parseInt(split[2]);
        this.numero = Integer.parseInt(split[3]);
        this.tipo = AccountType.valueOf(split[4]);
        this.limite = Float.parseFloat(split[5]);
        this.user = ModelFactory.getModel(User.class, "users", split[6]);
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

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", banco='" + banco + '\'' +
                ", agencia=" + agencia +
                ", numero=" + numero +
                ", tipo=" + tipo +
                ", limite=" + limite +
                ", user=" + user +
                '}';
    }
}
