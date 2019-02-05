package io.github.perrymant.moneymaker;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ReportLineTest {
    private static final String DATE_TIME = "2018-01-02";
    private static final int AMOUNT = 150;
    private static final String AMOUNT_FORMATTED = "£1.50";
    private static final String BALANCE_FORMATTED = "£1,234,567.89";
    private static final String DESCRIPTION = "Blah Blah - literally";

    @Test
    public void createsReportLineInExpectedFormat() {
        final int balance = 123456789;
        final Object[] rowItems = new ReportLine(makeTransaction(), balance).getRowItems();
        assertArrayEquals(
                new String[]{DATE_TIME,
                    TransactionType.CREDIT.name(),
                    AMOUNT_FORMATTED,
                    BALANCE_FORMATTED,
                    DESCRIPTION},
                rowItems);
    }

    private Transaction makeTransaction() {
        final Transaction transaction = new Transaction();
        transaction.setDate(DATE_TIME);
        transaction.setTransactionType(TransactionType.CREDIT);
        transaction.setAmount(AMOUNT);
        transaction.setDescription(DESCRIPTION);
        return transaction;
    }

}

