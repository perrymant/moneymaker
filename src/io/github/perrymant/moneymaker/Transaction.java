package io.github.perrymant.moneymaker;

import java.util.Date;

public class Transaction {
    private TransactionType transactionType;
    private Date date;
    private String description;
    private int amount;


    public Date getDate() {
        return date;
    }

    public Transaction setDate(Date date) {
        this.date = date;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    TransactionType getTransactionType() {
        return transactionType;
    }

    void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}

enum TransactionType {
    CREDIT,
    DEBIT;
}


// This is a POJO