package io.github.perrymant.moneymaker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileIOTest {

    @Test
    public void canReadData()  {
        FileIO fileIO = new FileIO();
        String fileName = "src/test/resources/dump/file_with_data";
        String expected = "2018/01/01, CREDIT, 200, 200, Got paid\n2018/01/02, DEBIT, 50, 150, Paid bill\n";
        String target = fileIO.read(fileName);
        assertEquals(expected, target);
    }

    @Test
    public void canAppendData() {
        FileIO fileIO = new FileIO();
        String fileName = "src/test/resources/dump/file_with_data_append_test";
        String dataToWrite = "2019/03/03, CREDIT, 200, 200, Got paid\n2019/03/04, DEBIT, 50, 150, Paid bill\n";
        String dataToAppend = "2018/01/01, CREDIT, 200, 200, Got paid\n2018/01/02, DEBIT, 50, 150, Paid bill\n";
        fileIO.write(dataToWrite, fileName);
        fileIO.append(dataToAppend, fileName);
        assertEquals(fileIO.read(fileName), dataToWrite + dataToAppend);
    }

}
