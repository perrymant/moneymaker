package io.github.perrymant.moneymaker;

import java.util.Arrays;

class Application {
    private final Budget budget;
    private final FileReader reader = new FileReader();
    private final Logger logger;

    private static final String HELP_FIXTURE_PATH = "moneymaker-help.txt";
    private static final String INVALID_ARGUMENT_ERROR_MESSAGE = "" +
            "Error: Invalid argument:\n" +
            "$ moneymaker help\n" +
            "for more info.";

    Application(Logger logger, Budget budget) {
        this.logger = logger;
        this.budget = budget;
    }

    void start(String[] args) {
        if (args.length == 0) {
            getInfo(INVALID_ARGUMENT_ERROR_MESSAGE);
        } else {
            if ("report".equals(args[0])) {
                getInfo(budget.report());
            } else if ("help".equals(args[0])) {
                getInfo(reader.read(HELP_FIXTURE_PATH));
            } else {
                getInfo(INVALID_ARGUMENT_ERROR_MESSAGE);
            }
        }
    }

    private void getInfo(String read) {
        getLogger().info(read);
    }

    private Logger getLogger() {
        return logger;
    }

}