package io.github.perrymant.moneymaker;

class Cli {
    static final String ERROR_MESSAGE = "Error: Invalid argument: moneymaker help for more info.";
    private final Budget budget;
    private final FileReader reader = new FileReader();

    private final Logger logger;

    Cli(Logger logger, TransactionMaker transactionMaker) {
        this.logger = logger;
        this.budget = new Budget(new Balance(), transactionMaker.getTransactions());
    }

    void start(String[] args) {
        if (args.length > 0) {
            if ("help".equals(args[0])) {
                logger.info(reader.read("moneymaker-help.txt"));
            } else if ("report".equals(args[0])) {
                logger.info(reader.read("report_seed_data.json"));
            } else if ("transaction".equals(args[0])) {
                budget.transaction(args);
            } else {
                logger.info(ERROR_MESSAGE);
            }
        } else {
            logger.info(ERROR_MESSAGE);
        }
    }

}