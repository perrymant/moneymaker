package io.github.perrymant.moneymaker;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ApplicationTest {

    private static final String INVALID_ARGUMENT_ERROR_MESSAGE = "" +
            "Error: Invalid argument:\n" +
            "$ moneymaker help\n" +
            "for more info.";
    private static final String HELP_MORE_ARGS = "help with more args";
    private static final String REPORT_MORE_ARGS = "report more args given";
    private static final String RANDOMSTRING = "random stuff here";

    private TestLogger logger = new TestLogger();
    private List<Transaction> transactions = new TransactionMaker().getTransactions();
    private Balance balance = new Balance();
    private Budget budget = new DefaultBudget(balance, transactions);
    private Application target = new Application(logger, budget);
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
    public void noArgumentsIsGiven_printsError() {
        target.start(new String[]{});
        Assert.assertEquals(INVALID_ARGUMENT_ERROR_MESSAGE, logger.getMessage());
    }

    @Test
    public void reportIsGiven_printsReport() {
        target.start(new String[]{"report"});
        Assert.assertEquals(REPORT, logger.getMessage());
    }

    @Test
    public void reportWithOtherArgsIsGiven_printsINVALID_ARGUMENT_ERROR_MESSAGE() {
        target.start(new String[]{REPORT_MORE_ARGS});
        Assert.assertEquals(INVALID_ARGUMENT_ERROR_MESSAGE, logger.getMessage());
    }

    @Test
    public void helpIsGiven_printsHelp() {
        target.start(new String[]{"help"});
        Assert.assertEquals(HELP_MESSAGE, logger.getMessage());
    }

    @Test
    public void helpWithOtherArgsIsGiven_printsINVALID_ARGUMENT_ERROR_MESSAGE() {
        target.start(new String[]{HELP_MORE_ARGS});
        Assert.assertEquals(INVALID_ARGUMENT_ERROR_MESSAGE, logger.getMessage());
    }

    @Test
    public void emptyStringGiven_printsINVALID_ARGUMENT_ERROR_MESSAGE() {
        target.start(new String[]{""});
        Assert.assertEquals(INVALID_ARGUMENT_ERROR_MESSAGE, logger.getMessage());
    }

    @Test
    public void randomStringGiven_printsINVALID_ARGUMENT_ERROR_MESSAGE() {
        target.start(new String[]{RANDOMSTRING});
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

