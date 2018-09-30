package io.github.perrymant.moneymaker;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import static java.lang.String.valueOf;

public class ReportLine extends Transaction implements Serializable {

    private int balance;

    ReportLine() {
    }

    ReportLine(final Transaction transaction, final int balance) {
        setAmount(transaction.getAmount());
        setDescription(transaction.getDescription());
        setTime(transaction.getTime());
        setTransactionType(transaction.getTransactionType());
        this.balance = balance;
    }

    String[] getRowItems() {
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(getLocalFromISO("GBP"));
        return new String[]{
                getTime(),
                getTransactionType().name(),
                currencyInstance.format((double)getAmount()/100),
                currencyInstance.format((double)getBalance()/100),
                getDescription()
        };
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}