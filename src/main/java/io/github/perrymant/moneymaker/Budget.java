package io.github.perrymant.moneymaker;

interface Budget {

    String report();

    String[][] createData();

    void updateBalance();
}

