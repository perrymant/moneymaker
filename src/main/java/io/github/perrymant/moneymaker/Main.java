package io.github.perrymant.moneymaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        if (args[0].equals("spring")) {
            SpringApplication.run(Main.class, args);
        } else if (args[0].equals("CLI")) {
            new Application(
                    new DefaultLogger(),
                    new DefaultTransactionMaker()
            ).start(new String[]{"report"});
        }
    }
}