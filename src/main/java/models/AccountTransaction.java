package models;

import models.annotations.ColumnName;
import models.annotations.PrimaryKey;

public class AccountTransaction {

    @PrimaryKey("id_account_transaction")
    private Long id;
    @ColumnName("id_account")
    private Account account;
    @ColumnName("id_transaction")
    private Transaction transaction;

    public AccountTransaction(Long id, Account account, Transaction transaction) {
        this.id = id;
        this.account = account;
        this.transaction = transaction;
    }

    // Constructor for genericDAO
    public AccountTransaction(String arg) {
        String[] split = arg.split(";");
        this.id = Long.parseLong(split[0]);
        this.account = ModelFactory.getModel(Account.class, "accounts", Long.parseLong(split[1]));
        this.transaction = ModelFactory.getModel(Transaction.class, "transaction", Long.parseLong(split[2]));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
