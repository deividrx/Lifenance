package models;

import models.annotations.ColumnName;
import models.annotations.PrimaryKey;

public class TransactionCard {

    @PrimaryKey("transaction_card_id")
    private long idTransactionCard;
    @ColumnName("card_id")
    private Card card;
    @ColumnName("transaction_id")
    private Transaction transaction;

    public TransactionCard(long idTransactionCard, Card card, Transaction transaction) {
        this.idTransactionCard = idTransactionCard;
        this.card = card;
        this.transaction = transaction;
    }

    // Constructor for genericDao
    public TransactionCard(String arg) {
        String[] split = arg.split(";");
        this.idTransactionCard = Long.parseLong(split[0]);
        this.card = ModelFactory.getModel(Card.class, "cards", Long.parseLong(split[1]));
        this.transaction = ModelFactory.getModel(Transaction.class, "transactions",
                Long.parseLong(split[2]));
    }

    public long getIdTransactionCard() {
        return idTransactionCard;
    }

    public void setIdTransactionCard(long idTransactionCard) {
        this.idTransactionCard = idTransactionCard;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
