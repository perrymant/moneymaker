package io.github.perrymant.moneymaker;

import java.text.NumberFormat;
import java.util.Locale;

class MoneyFormatter {
    private static final NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.UK);

    String formatPounds(int amount) {
        return currencyInstance.format((double) amount / 100);
    }

}