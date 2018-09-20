package io.github.perrymant.moneymaker;

import java.io.Serializable;

import static java.lang.String.valueOf;

public class ReportLine extends Transaction implements Serializable {

    private int balance;

    ReportLine() {
    }

    ReportLine(final Transaction transaction, final int balance) {
        setAmount(transaction.getAmount());
        setDescription(transaction.getDescription());
        setTime(transaction.getTime());
        setTransactionType(transaction.getTransactionType());
        this.balance = balance;
    }

    String[] getRowItems() {
        return new String[]{
                getTime(),
                getTransactionType().name(),
                valueOf(getAmount()),
                valueOf(balance),
                getDescription()
        };
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}