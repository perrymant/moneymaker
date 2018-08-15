package io.github.perrymant.moneymaker;

import java.io.FileWriter;
import java.io.IOException;

public class CSV {
    private final String header = "Date, Transaction Type, Amount, Balance, Description\n";


    void CSV_Write(String str) throws IOException {
        FileWriter fw = new FileWriter("Budget.csv");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        fw.write(header);
        fw.write(String.valueOf(sb));
        fw.close();
    }
}

