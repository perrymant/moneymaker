package io.github.perrymant.moneymaker;

class Application {
    private final DefaultBudget budget = new DefaultBudget(new Balance(), new TransactionMaker().getTransactions());
    private final FileReader reader = new FileReader();
    private final Logger logger;

    private static final String HELP_TXT = "moneymaker-help.txt";
    private static final String ERROR = "" +
            "Error: Invalid argument:\n" +
            "$ moneymaker help\n" +
            "for more info.";

    Application(Logger logger) {
        this.logger = logger;
    }

    void start(String[] args) {
        if (args.length == 0) {
            logger.info(ERROR);
        } else {
            if ("report".equals(args[0].split(" ")[0])) {
                logger.info(budget.report());
            } else if ("help".equals(args[0].split(" ")[0])) {
                logger.info(reader.read(HELP_TXT));
            } else {
                logger.info(ERROR);
            }
        }
    }
}