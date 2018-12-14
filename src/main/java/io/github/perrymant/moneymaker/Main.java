package io.github.perrymant.moneymaker;


import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void mgain(String[] args) {
        new Application(
                new DefaultLogger(),
                new DefaultTransactionMaker()
        ).start(args);
    }
}