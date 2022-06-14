package models;

import models.annotations.ColumnName;
import models.annotations.PrimaryKey;

import java.time.LocalDate;

public class Card {

    @PrimaryKey("card_id")
    private long id;
    @ColumnName("card_number")
    private long number;
    @ColumnName("validity")
    private LocalDate validity;
    @ColumnName("card_flag")
    private CardFlag cardFlag;
    @ColumnName("multa")
    private int multa;
    @ColumnName("limite")
    private float limite;
    @ColumnName("vencimento")
    private LocalDate vencimento;
    @ColumnName("fechamento")
    private LocalDate fechamento;
    @ColumnName("card_name")
    private String nome;
    @ColumnName("user_id")
    private User user;

    public Card(long id, long number, LocalDate validity, CardFlag cardFlag, int multa, float limite,
                LocalDate vencimento, LocalDate fechamento, String nome, User user) {
        this.id = id;
        this.number = number;
        this.validity = validity;
        this.cardFlag = cardFlag;
        this.multa = multa;
        this.limite = limite;
        this.vencimento = vencimento;
        this.fechamento = fechamento;
        this.nome = nome;
        this.user = user;
    }

    // Constructor for genericDAO
    public Card(String arg) {
        String[] split = arg.split(";");
        this.id = Long.parseLong(split[0]);
        this.number = Long.parseLong(split[1]);
        this.validity = LocalDate.parse(split[2]);
        this.cardFlag = ModelFactory.getModel(CardFlag.class, "flags", Long.parseLong(split[3]));
        this.multa = Integer.parseInt(split[4]);
        this.limite = Float.parseFloat(split[5]);
        this.vencimento = LocalDate.parse(split[6]);
        this.fechamento = LocalDate.parse(split[7]);
        this.nome = split[8];
        this.user = ModelFactory.getModel(User.class, "users", Long.parseLong(split[9]));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public LocalDate getValidity() {
        return validity;
    }

    public void setValidity(LocalDate validity) {
        this.validity = validity;
    }

    public CardFlag getFlag() {
        return cardFlag;
    }

    public void setFlag(CardFlag cardFlag) {
        this.cardFlag = cardFlag;
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

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public LocalDate getFechamento() {
        return fechamento;
    }

    public void setFechamento(LocalDate fechamento) {
        this.fechamento = fechamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CardFlag getCardFlag() {
        return cardFlag;
    }

    public void setCardFlag(CardFlag cardFlag) {
        this.cardFlag = cardFlag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

