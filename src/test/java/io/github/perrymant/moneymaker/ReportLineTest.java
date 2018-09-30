package io.github.perrymant.moneymaker;

import org.junit.Test;

import java.text.NumberFormat;
import java.util.Locale;

import static org.junit.Assert.assertArrayEquals;

public class ReportLineTest {
    private static final String DATE_TIME = "2018-01-02";
    private static final int AMOUNT = 150;
    private static final String DESCRIPTION = "Blah Blah - literally";

    @Test
    public void canDisplayCurrenciesInISOFormat() {
        final int balance = 123456789;
        final Object[] rowItems = new ReportLine(makeTransaction(), balance).getRowItems();
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(getLocalFromISO("GBP"));
        assertArrayEquals(
                new String[]{DATE_TIME,
                        TransactionType.CREDIT.name(),
                        currencyInstance.format((double)AMOUNT/100),
                        currencyInstance.format((double)balance/100),
                        DESCRIPTION},
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

    private Locale getLocalFromISO(String ISO_4217_GBP){
        Locale result = null;
        for (Locale locale : NumberFormat.getAvailableLocales()) {
            String code = NumberFormat.getCurrencyInstance(locale).
                    getCurrency().getCurrencyCode();
            if (ISO_4217_GBP.equals(code)) {
                result = locale;
                break;
            }
        }
        return result;
    }

}

