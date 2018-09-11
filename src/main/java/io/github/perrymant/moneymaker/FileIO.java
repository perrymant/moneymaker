package io.github.perrymant.moneymaker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

class FileIO {

    String read(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)), Charset.defaultCharset());
        } catch (RuntimeException | IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    void write(String data, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data);
        } catch (RuntimeException | IOException e) {
            e.printStackTrace();
        }
    }

    void append(String dataToAppend, String fileName) {
        final boolean append = true;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append))) {
            writer.append(dataToAppend);
        } catch (RuntimeException | IOException e) {
            e.printStackTrace();
        }
    }

}