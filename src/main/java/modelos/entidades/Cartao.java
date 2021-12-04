package modelos.entidades;

import java.util.Date;

public class Cartao {
    //Atributos
    private int numero = 0;
    private Date validade;
    private int bandeira = 0;
    private int multa = 0;
    private float limite = 0;
    private Date vencimento;
    private Date fechamento;
    private String nome = "";
    private int cvv = 0;
    private int id = 0;

    //private
    // Metodos
    public Cartao() {

    }

    public Cartao(int numero, Date validade, int bandeira, int multa, float limite, Date vencimento,
                  Date fechamento, String nome, int cvv, int id) {
        this.numero = numero;
        this.validade = validade;
        this.bandeira = bandeira;
        this.multa = multa;
        this.limite = limite;
        this.vencimento = vencimento;
        this.fechamento = fechamento;
        this.nome = nome;
        this.cvv = cvv;
        this.id = id;

    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public int getBandeira() {
        return bandeira;
    }

    public void setBandeira(int bandeira) {
        this.bandeira = bandeira;
    }

    public int getMulta() {
        return multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Date getFechamento() {
        return fechamento;
    }

    public void setFechamento(Date fechamento) {
        this.fechamento = fechamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  +
                numero + ";" + validade + ";" + bandeira +"" +
                ";"+ multa + ";" + limite + ";"+ vencimento + ";"+ fechamento +
                ";"+ nome +";"  + ";" + cvv + ";" + id ;
    }
}

