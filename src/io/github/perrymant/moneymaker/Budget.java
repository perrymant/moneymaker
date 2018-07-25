package io.github.perrymant.moneymaker;

import java.util.List;

class Budget {
    private final Balance balance;

    Budget(Balance balance, List<Transaction> transactions) {
        this.balance = balance;
    }

    void start() {
        balance.increment(100);
    }
}


