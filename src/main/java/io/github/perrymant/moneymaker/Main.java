package io.github.perrymant.moneymaker;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Balance balance = new Balance();
        List<Transaction> transactions = new TransactionMaker().getTransactions();
        new Application(new DefaultLogger(), new DefaultBudget(balance, transactions), args).start();
    }
}