package io.github.perrymant.moneymaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            new Cli(
                    new DefaultLogger(),
                    new DefaultTransactionMaker()
            ).start(args);
        } else {
            SpringApplication.run(Main.class, args);
        }
    }
}