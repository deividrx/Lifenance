package models;

import models.annotations.ColumnName;
import models.annotations.PrimaryKey;

public class TransactionAccount {

    @PrimaryKey("id_transaction_account")
    private long id;
    @ColumnName("transaction_id")
    private Transaction transaction;
    @ColumnName("account_id")
    private Account account;

    public TransactionAccount(long id, Transaction transaction, Account account) {
        this.id = id;
        this.transaction = transaction;
        this.account = account;
    }

    // Constructor for genericDao
    public TransactionAccount(String arg) {
        String[] split = arg.split(";");
        this.id = Long.parseLong(split[0]);
        this.transaction = ModelFactory.getModel(Transaction.class, "transactions", Long.parseLong(split[1]));
        this.account = ModelFactory.getModel(Account.class, "accounts", Long.parseLong(split[2]));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
