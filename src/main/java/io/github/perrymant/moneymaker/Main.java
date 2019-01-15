package io.github.perrymant.moneymaker;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        new Application(
                new DefaultLogger(),
                new DefaultTransactionMaker()
        ).start(args);
    }
}