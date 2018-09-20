package io.github.perrymant.moneymaker;

import java.io.IOException;

class FileIOException extends RuntimeException {
    FileIOException(String message, IOException e) {
        super(message, e);
    }
}