package io.github.perrymant.moneymaker;

public class Main {
    public static void main(String[] args) {
        new Application(
                new DefaultLogger(),
                new DefaultTransactionMaker()
        ).start(args);
    }
}