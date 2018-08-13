package io.github.perrymant.moneymaker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReportLineTest {
    private static final String DATE_TIME = "2018/01/02";

    @Test
    public void canReportALine() {
        final int amount = 150;
        final String description = "Blah Blah - literally";
        final Transaction transaction = makeTransaction(TransactionType.CREDIT, amount, description);
        final int newBalance = 250;
        final ReportLine reportLine = new ReportLine(transaction, newBalance);
        final String expected = "2018/01/02, CREDIT, 150, Blah Blah - literally, 250";
        assertEquals(expected, reportLine.toString());
    }

    private Transaction makeTransaction(final TransactionType transactionType,
                                        final int amount,
                                        final String description) {
        final Transaction transaction = new Transaction();
        transaction.setTime(DATE_TIME);
        transaction.setTransactionType(transactionType);
        transaction.setAmount(amount);
        transaction.setDescription(description);
        return transaction;
    }

}

