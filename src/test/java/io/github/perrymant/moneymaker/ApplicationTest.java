package io.github.perrymant.moneymaker;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ApplicationTest {

    private static final String INVALID_ARGUMENT_ERROR_MESSAGE = "" +
            "Error: Invalid argument:\n" +
            "$ moneymaker help\n" +
            "for more info.";
    private static final String HELP_MORE_ARGS = "help with more args";
    private static final String RANDOMSTRING = "random stuff here";
    private String[] EMPTY_STRING = new String[]{""};
    private String[] REPORT_STRING = new String[]{"report"};
    private String UPDATED_REPORT_STRING = "is this the string I need to update...";

    private String[] REPORT_MORE_ARGS = new String[]{"report more args given"};

    private TestLogger logger = new TestLogger();
    private List<Transaction> transactions = new TransactionMaker().getTransactions();
    private Balance balance = new Balance();
    private TestBudget budget = new TestBudget(balance, transactions);
    private static final String REPORT = "" +
            "╔════════════╤══════════════════╤════════╤═════════╤═════════════╗\n" +
            "║ Time       │ Transaction Type │ Amount │ Balance │ Description ║\n" +
            "╠════════════╪══════════════════╪════════╪═════════╪═════════════╣\n" +
            "║ 2018-01-01 │ CREDIT           │ £1.25  │ £1.25   │ Got paid    ║\n" +
            "╟────────────┼──────────────────┼────────┼─────────┼─────────────╢\n" +
            "║ 2018-01-01 │ CREDIT           │ £1.25  │ £2.50   │ Got paid    ║\n" +
            "╟────────────┼──────────────────┼────────┼─────────┼─────────────╢\n" +
            "║ 2018-01-02 │ DEBIT            │ £0.72  │ £1.78   │ Paid bill   ║\n" +
            "╚════════════╧══════════════════╧════════╧═════════╧═════════════╝\n";

    private static final String HELP_MESSAGE = "" +
            "NAME:\n" +
            "    moneymaker -- a budget calculator.\n" +
            "SYNOPSIS:\n" +
            "    moneymaker [transaction] [<amount>][\"<description>\"][<date>]\n" +
            "    moneymaker [report]\n" +
            "    moneymaker [help]\n" +
            "DESCRIPTION:\n" +
            "    moneymaker is able to take credit and debit transactions,\n" +
            "    and then display these as a report.\n" +
            "OPTIONS:\n" +
            "    transaction [<amount>][\"<description>\"][<date>]\n" +
            "        To add credit you must add a description.\n" +
            "        If no date is provided then the current date will be used.\n" +
            "    report\n" +
            "        The report command will print out all transactions in a table.\n" +
            "    help\n" +
            "        This documentation.\n" +
            "EXAMPLES:\n" +
            "    moneymaker transaction 125 \"Got paid\" 2018-01-01\n" +
            "    moneymaker transaction 125 \"Got paid\" 2018-01-01\n" +
            "    moneymaker transaction -72 \"Paid bill\"\n" +
            "    moneymaker report\n" +
            "\n" +
            "    *** Output ***\n" +
            "        ╔════════════╤══════════════════╤════════╤═════════╤═════════════╗\n" +
            "        ║ Time       │ Transaction Type │ Amount │ Balance │ Description ║\n" +
            "        ╠════════════╪══════════════════╪════════╪═════════╪═════════════╣\n" +
            "        ║ 2018-01-01 │ CREDIT           │ £1.25  │ £1.25   │ Got paid    ║\n" +
            "        ╟────────────┼──────────────────┼────────┼─────────┼─────────────╢\n" +
            "        ║ 2018-01-01 │ CREDIT           │ £1.25  │ £2.50   │ Got paid    ║\n" +
            "        ╟────────────┼──────────────────┼────────┼─────────┼─────────────╢\n" +
            "        ║ 2018-01-02 │ DEBIT            │ £0.72  │ £1.78   │ Paid bill   ║\n" +
            "        ╚════════════╧══════════════════╧════════╧═════════╧═════════════╝\n";


    @Test
    public void loopedTest() {
        String[][] argsTestContentArray = new String[][]{
                EMPTY_STRING,
                REPORT_STRING,
                REPORT_MORE_ARGS};

        for (String[] thing : argsTestContentArray) {
            new Application(logger, budget, thing).start();
            System.out.println(logger.getMessage());
//            Assert.assertEquals(, logger.getMessage());
        }
    }

    @Test
    public void noArgumentsIsGiven_printsError() {
        new Application(logger, budget, EMPTY_STRING).start();
        Assert.assertEquals(INVALID_ARGUMENT_ERROR_MESSAGE, logger.getMessage());
    }

    @Test
    public void reportIsGiven_printsReport() {
        new Application(logger, budget, REPORT_STRING).start();
        Assert.assertEquals(UPDATED_REPORT_STRING, logger.getMessage());
    }

    @Test
    public void reportWithOtherArgsIsGiven_printsINVALID_ARGUMENT_ERROR_MESSAGE() {
        new Application(logger, budget, REPORT_MORE_ARGS).start();
        Assert.assertEquals(INVALID_ARGUMENT_ERROR_MESSAGE, logger.getMessage());
    }

    @Test
    public void helpIsGiven_printsHelp() {
        new Application(logger, budget, new String[]{"help"}).start();
        Assert.assertEquals(HELP_MESSAGE, logger.getMessage());
    }

    @Test
    public void helpWithOtherArgsIsGiven_printsINVALID_ARGUMENT_ERROR_MESSAGE() {
        new Application(logger, budget, new String[]{HELP_MORE_ARGS}).start();
        Assert.assertEquals(INVALID_ARGUMENT_ERROR_MESSAGE, logger.getMessage());
    }

    @Test
    public void emptyStringGiven_printsINVALID_ARGUMENT_ERROR_MESSAGE() {
        new Application(logger, budget, new String[]{""}).start();
        Assert.assertEquals(INVALID_ARGUMENT_ERROR_MESSAGE, logger.getMessage());
    }

    @Test
    public void randomStringGiven_printsINVALID_ARGUMENT_ERROR_MESSAGE() {
        new Application(logger, budget, new String[]{RANDOMSTRING}).start();
        Assert.assertEquals(INVALID_ARGUMENT_ERROR_MESSAGE, logger.getMessage());
    }


    private class TestLogger implements Logger {
        private String message;

        String getMessage() {
            return message;
        }

        @Override
        public void info(String message) {
            this.message = message;
        }
    }


}

