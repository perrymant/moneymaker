package io.github.perrymant.moneymaker;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

class FileReader {

    String read(String fileName) {
        try {
            final URI uri = getClass().getClassLoader().getResource(fileName).toURI();
            return new String(readAllBytes(get(uri)));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

}