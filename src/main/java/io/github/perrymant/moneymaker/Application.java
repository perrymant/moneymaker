package io.github.perrymant.moneymaker;

class Application {
    private final Budget budget = new Budget(new Balance(), new TransactionMaker().getTransactions());
    private final FileReader reader = new FileReader();

    private final Logger logger;

    Application(Logger logger) {
        this.logger = logger;
    }

    void start(String[] args) {
        if (args.length > 0 && "help".equals(args[0])) {
            logger.info(reader.read("moneymaker-help.txt"));
        } else {
            logger.info(budget.report());
        }
    }
}