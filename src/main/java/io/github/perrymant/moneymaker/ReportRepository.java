package io.github.perrymant.moneymaker;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
class ReportRepository {
    private ObjectMapper mapper = new ObjectMapper();

    Account read(String fileName) {
        try {
            return mapper.readValue(new File(fileName), Account.class);
        } catch (IOException e) {
            // The file has not yet been created. This means that the user has not yet written any data to moneymaker.
            // In this case, we treat this as being a 'new' empty account, instead of throwing an exception.
            return new Account();
        }
    }

    void write(Account data, String fileName) {
        try {
            mapper.writeValue(new File(fileName), data);
        } catch (IOException e) {
            throw new FileIOException("FileIOException: couldn't write", e);
        }
    }

}


