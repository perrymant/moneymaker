package io.github.perrymant.moneymaker;

class DefaultLogger implements Logger {
    @Override
    public void info(final String str) {
        System.out.println(str);
    }
}
