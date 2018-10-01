package io.github.perrymant.moneymaker;

import java.text.NumberFormat;
import java.util.Locale;

class MoneyFormatter {
    private static final Locale UK = Locale.UK;

    static String formatPounds(int amount) {
        final double value = (double) amount / 100;
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(UK);
        return currencyInstance.format(value);
    }

}