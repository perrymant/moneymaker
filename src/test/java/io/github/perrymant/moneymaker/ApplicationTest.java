package io.github.perrymant.moneymaker;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static io.github.perrymant.moneymaker.Application.ERROR_MESSAGE;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;


public class ApplicationTest {

    private static final String PRE_DETERMINED_JSON_REPORT = "" +
            "{\n" +
            "  \"report\":[\n" +
            "    {\n" +
            "      \"date\":\"2018-01-01\",\n" +
            "      \"amount\":125,\n" +
            "      \"description\":\"Got paid\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"date\":\"2018-01-02\",\n" +
            "      \"amount\":-72,\n" +
            "      \"description\":\"Paid bill\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    private static final String REPORT_AFTER_TRANSACTION = "" +
            "╔════════════╤══════════════════╤════════╤═════════╤═════════════╗\n" +
            "║ Time       │ Transaction Type │ Amount │ Balance │ Description ║\n" +
            "╠════════════╪══════════════════╪════════╪═════════╪═════════════╣\n" +
            "║ 2018-10-30 │ CREDIT           │ £1.00  │ £1.00   │ A Watch     ║\n" +
            "╟────────────┼──────────────────┼────────┼─────────┼─────────────╢\n" +
            "║ 2018-01-04 │ CREDIT           │ £1.25  │ £2.25   │ Got paid    ║\n" +
            "╟────────────┼──────────────────┼────────┼─────────┼─────────────╢\n" +
            "║ 2018-01-02 │ DEBIT            │ £0.72  │ £1.53   │ Paid bill   ║\n" +
            "╟────────────┼──────────────────┼────────┼─────────┼─────────────╢\n" +
            "║ 2018-01-01 │ CREDIT           │ £1.25  │ £2.78   │ Got paid    ║\n" +
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

    private TestLogger logger = new TestLogger();
    private TestTransactionMaker testTransactionMaker = new TestTransactionMaker();
    private Application target = new Application(logger, testTransactionMaker);

    @Test
    public void givenHelpLogsHelpMessage() {
        target.start(new String[]{"help"});
        assertEquals(HELP_MESSAGE, logger.getMessage());
    }

    @Test
    public void givenNoArgsLogsErrorMessage() {
        target.start(new String[]{"GarbAgE"});
        assertEquals(ERROR_MESSAGE, logger.getMessage());
    }

    @Test
    public void givenReportLogsReport() {
        target.start(new String[]{"report"});
        assertEquals(PRE_DETERMINED_JSON_REPORT, logger.getMessage());
    }

    @Test
    public void givenGarbageLogsErrorMessage() {
        target.start(new String[]{"fish"});
        assertEquals(ERROR_MESSAGE, logger.getMessage());
    }

    @Ignore
    @Test
    public void givenTransactionArg_makeTransaction() {
        String[] transactionExample = new String[]{"transaction", "100", "A Watch", "2018-10-30"};
        target.start(transactionExample);
        target.start(new String[]{"report"});
        assertEquals(REPORT_AFTER_TRANSACTION, logger.getMessage());
    }

    private class TestTransactionMaker implements TransactionMaker {
        public List<Transaction> getTransactions() {
            return asList(
                    makeTransaction("2018-01-04", TransactionType.CREDIT, 125, "Got paid"),
                    makeTransaction("2018-01-02", TransactionType.DEBIT, 72, "Paid bill"),
                    makeTransaction("2018-01-01", TransactionType.CREDIT, 125, "Got paid"));
        }

        private Transaction makeTransaction(String time, TransactionType type, int amount, String description) {
            final Transaction transaction = new Transaction();
            transaction.setTransactionType(type);
            transaction.setTime(time);
            transaction.setDescription(description);
            transaction.setAmount(amount);
            return transaction;
        }
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

