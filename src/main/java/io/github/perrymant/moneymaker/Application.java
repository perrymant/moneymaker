package io.github.perrymant.moneymaker;

class Application {

    private static final Budget budget = new Budget(new Balance(), new TransactionMaker().getTransactions());

    void start(String[] args) {
        if (args[0].equals("log")) {
            new Logger().info(budget.report());
        }
    }

}
