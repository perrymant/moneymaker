package io.github.perrymant.moneymaker;

import java.io.IOException;

public class Moneymaker {

    private static final Budget budget = new Budget(new Balance(), new TransactionMaker().getTransactions());

    public static void main(String[] args) throws IOException {
        switch (args[0]) {
            case "log":
                new Logger().info(budget.report());
                System.out.println("output logged");
                break;
            case "wtxt":
                new TXT().TXT_Write(budget.report());
                System.out.println("output to \"Budget.txt\"");
                break;
            case "wcsv":
                new CSV().CSV_Write(budget.reportCSV());
                System.out.println("output to \"Budget.csv\"");
                break;
        }
    }
}
