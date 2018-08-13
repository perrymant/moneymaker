package io.github.perrymant.moneymaker;

public class Moneymaker {

    private static final Budget budget = new Budget(new Balance(), new TransactionMaker().getTransactions());

    public static void main(String[] args) {
        new Logger().info(budget.report());
    }
}
