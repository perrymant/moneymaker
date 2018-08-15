package io.github.perrymant.moneymaker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReportLineTest {
    private static final String DATE_TIME = "2018/01/02";

    @Test
    public void canReportALine() {
        final Transaction transaction = makeTransaction();
        final int newBalance = 250;
        final ReportLine reportLine = new ReportLine(transaction, newBalance);
        final String expected = "2018/01/02, CREDIT, 150, Blah Blah - literally, 250";
        assertEquals(expected, reportLine.toStringCSV());
    }

    private Transaction makeTransaction() {
        final Transaction transaction = new Transaction();
        transaction.setTime(DATE_TIME);
        transaction.setTransactionType(TransactionType.CREDIT);
        transaction.setAmount(150);
        transaction.setDescription("Blah Blah - literally");
        return transaction;
    }

}

