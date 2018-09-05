package io.github.perrymant.moneymaker;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ReportLineTest {
    private static final String DATE_TIME = "2018/01/02";
    private static final int AMOUNT = 150;
    private static final String DESCRIPTION = "Blah Blah - literally";

    @Test
    public void canReportALine() {
        final Transaction transaction = makeTransaction();
        final int newBalance = 250;
        final ReportLine reportLine = new ReportLine(transaction, newBalance);
        final String expected = "2018/01/02, CREDIT, 150, Blah Blah - literally, 250";
        assertEquals(expected, reportLine.toString());
    }

    @Test
    public void createsReportLineInExpectedFormat() {
        final int balance = 2134;
        final Object[] rowItems = new ReportLine(makeTransaction(), balance).getRowItems();
        assertArrayEquals(
                new Object[]{DATE_TIME, TransactionType.CREDIT, AMOUNT, balance, DESCRIPTION},
                rowItems);
    }

    private Transaction makeTransaction() {
        final Transaction transaction = new Transaction();
        transaction.setTime(DATE_TIME);
        transaction.setTransactionType(TransactionType.CREDIT);
        transaction.setAmount(AMOUNT);
        transaction.setDescription(DESCRIPTION);
        return transaction;
    }


}

