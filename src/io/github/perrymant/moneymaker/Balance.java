package io.github.perrymant.moneymaker;

class Balance {
    private double value = 0;

    double get() {
        return value;
    }

    void increment(final double i) {
        this.value += i;
    }
}
