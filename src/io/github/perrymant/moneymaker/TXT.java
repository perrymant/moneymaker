package io.github.perrymant.moneymaker;

import java.io.FileWriter;
import java.io.IOException;

class TXT {
    private final String header = (String.format("| %-11s| %-18s| %-18s| %-18s| %-34s|\n", "Date", "Transaction Type", "Amount", "Balance", "Description"));

    void TXT_Write(String str) throws IOException {
        FileWriter fw = new FileWriter("Budget.txt");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        fw.write(header);
        fw.write("|============+===================+===================+===================+===================================|\n");
        fw.write(sb.toString());
        fw.close();
    }
}
