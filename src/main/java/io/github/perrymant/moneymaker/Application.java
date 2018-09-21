package io.github.perrymant.moneymaker;

class Application {
    private final Budget budget = new Budget(new Balance(), new TransactionMaker().getTransactions());

    void start(String[] args) {
        if(args.length == 0) {
            System.out.println("No arguments given. Proper usage is:\n$ java moneymaker -log");
            System.exit(0);
        } else if (args[0].equals("-log")) {
            new Logger().info(budget.report());
        } else {
            System.out.println("Incorrect argument given. Proper usage is:\n$ java moneymaker -log");
            System.exit(0);
        }
    }
}
