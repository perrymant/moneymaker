package io.github.perrymant.moneymaker;

public class Moneymaker {
    public static void main(String[] args) {
        new Budget(new Balance(), new TransactionMaker().getTransactions()).report();
    }
}
