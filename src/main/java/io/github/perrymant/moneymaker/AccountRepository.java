package io.github.perrymant.moneymaker;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


class AccountRepository {

    Account read(String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(fileName), Account.class);
        } catch (IOException e) {
            throw new FileIOException("FileIOException: couldn't read",e);
        }
    }

    void write(Account data, String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(fileName), data);
        } catch (IOException e) {
            throw new FileIOException("FileIOException: couldn't write",e);
        }
    }

    private class FileIOException extends RuntimeException {
        FileIOException(String message, IOException e) {
            super(message, e);
        }
    }
}


