package io.github.perrymant.moneymaker;

import static io.github.perrymant.moneymaker.TransactionType.CREDIT;

class Transaction {
    private String time;
    private TransactionType transactionType;
    private int amount;
    private String description;
    private int balance;

    String getTime() {
        return time;
    }

    void setTime(String time) {
        this.time = time;
    }

    TransactionType getTransactionType() {
        return transactionType;
    }

    void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    int getAmount() {
        return amount;
    }

    void setAmount(int amount) {
        this.amount = amount;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    String reportStringFormat() {
        return  getTime() + ", " + getTransactionType() + ", " + getAmount() + ", " + getDescription();
    }

    int getBalance() {
        return balance;
    }

    void setBalance(int balance) {
        this.balance = balance;
    }

//    void updateBalance(final int amount) {
//        final int sign = getTransactionType() == CREDIT ? 1 : -1;
//        this.balance += (sign * getAmount());
//        System.out.println(getBalance());
//    }


}
