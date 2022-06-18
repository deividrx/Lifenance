package models;

import models.annotations.ColumnName;
import models.annotations.PrimaryKey;

import java.time.LocalDate;

public class Transaction {

    @PrimaryKey("transaction_id")
    private long idTransaction;
    @ColumnName("transaction_value")
    private float value;
    @ColumnName("transaction_name")
    private String name;
    @ColumnName("transaction_initial_date")
    private LocalDate dataInicial;
    @ColumnName("transaction_final_date")
    private LocalDate dataFinal;
    @ColumnName("transaction_description")
    private String description;
    @ColumnName("user_cpf")
    private User user;


    public Transaction(long idTransaction, float value, String name, LocalDate dataInicial, LocalDate dataFinal, String description, User user) {
        this.idTransaction = idTransaction;
        this.value = value;
        this.name = name;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.description = description;
        this.user = user;
    }

    // Constructor for genericDAO
    public Transaction(String args) {
        String[] split = args.split(";");
        this.idTransaction = Long.parseLong(split[0]);
        this.value = Float.parseFloat(split[1]);
        this.name = split[2];
        this.dataInicial = LocalDate.parse(split[3]);
        this.dataFinal = LocalDate.parse(split[4]);
        this.description = split[5];
        this.user = ModelFactory.getModel(User.class, "users", split[6]);
    }


    public long getIdTransaction() {
        return this.idTransaction;
    }

    public void setIdTransaction(long idTransaction) {
        this.idTransaction = idTransaction;
    }

    public float getValue() {
        return this.value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDataInicial() {
        return this.dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return this.dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
