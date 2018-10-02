package io.github.perrymant.moneymaker;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

class HelpFile {

    String read(String fileName) {
        try {
            System.out.println(new String(Files.readAllBytes(Paths.get(fileName)), Charset.defaultCharset()));
            return new String(Files.readAllBytes(Paths.get(fileName)), Charset.defaultCharset());
        } catch (RuntimeException | IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
