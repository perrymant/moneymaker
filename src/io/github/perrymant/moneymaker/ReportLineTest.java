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
        assertEquals(expected, reportLine.toString());
    }

    @Test
    public void canReportWithHeaderInfo() {
        final Transaction transaction = makeTransaction();
        final int newBalance = 150;
        final ReportLine reportLine = new ReportLine(transaction, newBalance);
        final String expected = "Date, Transaction Type, Amount, Description, Balance\n" +
                                "2018/01/02, CREDIT, 150, Blah Blah - literally, 150";
        assertEquals(expected, reportLine.toString());
    }

    @Test
    public void canReportWithHeaderWithTabSpacing() {
        final Transaction transaction = makeTransaction();
        final int newBalance = 150;
        final ReportLine reportLine = new ReportLine(transaction, newBalance);
        final String expected = "Date\t\t| Transaction Type\t| Amount\t| Description\t\t| Balance\n" +
                                "2018/01/02, CREDIT, 150, Blah Blah - literally, 150";
        assertEquals(expected, reportLine.toString());
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

