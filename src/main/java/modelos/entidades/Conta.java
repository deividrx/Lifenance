package modelos.entidades;

import modelos.entidades.enums.TipoDeConta;

public class Conta {
    //Atributos
    private int numero = 0;
    private int agencia = 0;
    private TipoDeConta tipo ;
    private float limite = 0 ;
    private float saldo = 0;
    private int idBanco = 0 ;
    private int id = 0;

    // metodos
    public Conta() {
    }
    
    public Conta(int numero, int agencia, TipoDeConta tipo, float limite, float saldo, int idBanco,int id) {
        this.numero =  numero;
        this.agencia=  agencia;
        this.tipo=  tipo;
        this.limite =  limite;
        this.saldo =  saldo;
        this.idBanco=  idBanco;
        this.id =  id;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoDeConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeConta tipo) {
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

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return numero +";"+ agencia + ";"+ tipo +";" + limite +";" + saldo +";"+ idBanco +";"+ id;
    }
}
