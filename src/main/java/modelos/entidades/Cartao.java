package modelos.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cartao {
    //Atributos
    private long numero = 0;
    private Date validade;
    private String bandeira = "";
    private int multa = 0;
    private float limite = 0;
    private Date vencimento;
    private Date fechamento;
    private String nome = "";
    private int cvv = 0;
    private int id = 0;
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyyy");

    // Metodos
    public Cartao() {

    }

    public SimpleDateFormat getFormat() {
        return format;
    }

    public void setFormat(SimpleDateFormat format) {
        this.format = format;
    }

    public Cartao(String[] dados)  throws Exception {
        this.numero = Long.parseLong(dados[0]);
        this.validade = format.parse(dados[1]);
        this.bandeira = dados[2];
        this.multa = Integer.parseInt(dados[3]) ;
        this.limite = Float.parseFloat(dados[4]);
        this.vencimento = format.parse(dados[5]);
        this.fechamento = format.parse(dados[6]);
        this.nome = dados[7];
        this.cvv = Integer.parseInt(dados[8]);
        this.id = Integer.parseInt(dados[9]);
    }

    public Cartao(Long numero, Date validade, String bandeira, int multa, float limite, Date vencimento,
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

    public long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
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
                numero + ";" + format.format(validade) + ";" + bandeira +"" +
                ";"+ multa + ";" + limite + ";"+ format.format(vencimento) + ";"+ format.format(fechamento) +
                ";"+ nome +";" + cvv + ";" + id ;
    }
}

