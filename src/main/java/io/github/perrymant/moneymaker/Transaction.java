package io.github.perrymant.moneymaker;

class Transaction {
    private String time;
    private TransactionType transactionType;
    private int amount;
    private String description;

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

<<<<<<< HEAD:src/io/github/perrymant/moneymaker/Transaction.java
    String reportStringFormat() {

        return  getTime() + "\t| " + getTransactionType() + "\t\t\t| " + getAmount() + "\t\t| " + getDescription();
    }
=======
>>>>>>> b501cd59f02d273b9d0ae5d38276bb73a5193ca3:src/main/java/io/github/perrymant/moneymaker/Transaction.java
}
