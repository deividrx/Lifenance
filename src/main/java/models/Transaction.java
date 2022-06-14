package models;

import models.annotations.ColumnName;
import models.annotations.PrimaryKey;
import models.enumeration.TransactionType;

import java.time.LocalDate;

public class Transaction {

    @PrimaryKey("id_transaction")
    private long idTransaction;
    @ColumnName("transaction_value")
    private float value;
    @ColumnName("transaction_type")
    private TransactionType type;
    @ColumnName("transaction_name")
    private String name;
    @ColumnName("transaction_date")
    private LocalDate date;

    public Transaction(long idTransaction, float value, TransactionType type, String name, LocalDate date) {
        this.idTransaction = idTransaction;
        this.value = value;
        this.type = type;
        this.name = name;
        this.date = date;
    }

    // Constructor for genericDAO
    public Transaction(String arg) {
        String[] split = arg.split(";");
        this.idTransaction = Long.parseLong(split[0]);
        this.value = Float.parseFloat(split[1]);
        this.type = TransactionType.valueOf(split[2]);
        this.name = split[3];
        this.date = LocalDate.parse(split[4]);
    }

    public long getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(long idTransaction) {
        this.idTransaction = idTransaction;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
