package io.github.perrymant.moneymaker;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileIOTest {

    @Test
    public void canReadData() throws IOException {
        String fileName = "src/test/java/io/github/perrymant/moneymaker/file_with_data";
        String expected = "2018/01/01, CREDIT, 200, 200, Got paid\n2018/01/02, DEBIT, 50, 150, Paid bill\n";
        String target = FileIO.read(fileName);
        assertEquals(expected, target);
    }

    @Test
    public void canWriteData() throws IOException {
        String fileName = "src/test/java/io/github/perrymant/moneymaker/file_with_data_write_test";
        String dataToWrite = "2019/03/03, CREDIT, 200, 200, Got paid\n2019/03/04, DEBIT, 50, 150, Paid bill\n";
        new FileIO().write(dataToWrite, fileName);
        assertEquals(FileIO.read(fileName), dataToWrite);
    }

    @Test
    public void canAppendData() throws IOException {
        String fileName = "src/test/java/io/github/perrymant/moneymaker/file_with_data_append_test";
        String dataToWrite = "2019/03/03, CREDIT, 200, 200, Got paid\n2019/03/04, DEBIT, 50, 150, Paid bill\n";
        String dataToAppend = "2018/01/01, CREDIT, 200, 200, Got paid\n2018/01/02, DEBIT, 50, 150, Paid bill\n";
        new FileIO().write(dataToWrite, fileName);
        new FileIO().append(dataToAppend, fileName);
        assertEquals(FileIO.read(fileName), dataToWrite + dataToAppend);
    }
}
