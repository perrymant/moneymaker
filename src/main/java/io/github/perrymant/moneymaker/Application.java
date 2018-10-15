package io.github.perrymant.moneymaker;

class Application {
    private final Budget budget;
    private final FileReader reader = new FileReader();
    private final Logger logger;
    private Object[] args;

    private static final String HELP_FIXTURE_PATH = "moneymaker-help.txt";
    private static final String INVALID_ARGUMENT_ERROR_MESSAGE = "" +
            "Error: Invalid argument:\n" +
            "$ moneymaker help\n" +
            "for more info.";

    Application(Logger logger, Budget budget, Object[] args) {
        this.logger = logger;
        this.budget = budget;
        this.args = args;
    }

    void start() {
        logger.info(stringToLogger());
    }

    private String stringToLogger() {
        if (args.length > 0) {
            if ("report".equals(args[0])) {
                return budget.report();
            }
            if ("help".equals(args[0])) {
                return reader.read(HELP_FIXTURE_PATH);
            }
        }
        return INVALID_ARGUMENT_ERROR_MESSAGE;
    }

}