package io.github.perrymant.moneymaker;

class Balance {
    private int value = 0;

    int get() {
        return value;
    }

    void increment(final int i) {
        this.value += i;
    }
}
