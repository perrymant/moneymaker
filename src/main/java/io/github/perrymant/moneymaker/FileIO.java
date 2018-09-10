package io.github.perrymant.moneymaker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FileIO {

    static String read(String fileName) throws IOException {
        BufferedReader text = new BufferedReader(new FileReader(fileName));
        List<String> data = new ArrayList<>();
        String s;
        while ((s = text.readLine()) != null) {
            data.add(s + "\n");
        }
        text.close();
        return String.join("", data);
    }

    void write(String data, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(data);
        writer.close();
    }

    void append(String dataToAppend, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.append(dataToAppend);
        writer.close();
    }
}
