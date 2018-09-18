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
        } catch (IOException e) {
            throw new FileIOException("Exception: Couldn't read from file!", e);
        }
    }

    void write(String data, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data);
        } catch (IOException e) {
            throw new FileIOException("Exception: Couldn't write to file!", e);
        }
    }

    void append(String dataToAppend, String fileName) {
        final boolean append = true;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append))) {
            writer.append(dataToAppend);
        } catch (IOException e) {
            throw new FileIOException("Exception: Couldn't append to file!", e);
        }
    }

    private class FileIOException extends RuntimeException {
        FileIOException(String message, IOException e) {
            super(message, e);
        }
    }
}
