package io.github.perrymant.moneymaker;

class Application {
    private final Budget budget = new Budget(new Balance(), new TransactionMaker().getTransactions());

    void start(String[] args) {
        new Logger().info(budget.report());
    }
}