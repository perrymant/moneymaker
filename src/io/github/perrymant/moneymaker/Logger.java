package io.github.perrymant.moneymaker;

class Logger {
    void info(final String str) {
        System.out.println("Date\t\t| Transaction Type\t| Amount\t| Balance\t| Description\t\t\t|");
        System.out.println("=================================================================================");
        System.out.println(str);
    }
}