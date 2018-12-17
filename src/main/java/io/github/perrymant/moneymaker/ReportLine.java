package io.github.perrymant.moneymaker;

import java.io.Serializable;

public class ReportLine extends Transaction implements Serializable {

    private int balance;
    private MoneyFormatter moneyFormatter = new MoneyFormatter();

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
                moneyFormatter.formatPounds(getAmount()),
                moneyFormatter.formatPounds(getBalance()),
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