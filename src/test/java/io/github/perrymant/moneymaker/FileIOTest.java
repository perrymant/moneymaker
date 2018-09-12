package io.github.perrymant.moneymaker;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileIOTest {

    @Test
    public void canAppendData() {
        String fileName = FileUtils.getTempDirectoryPath() + "/file_with_data_append_test";
        String dataToWrite = "2019/03/03, CREDIT, 200, 200, Got paid\n2019/03/04, DEBIT, 50, 150, Paid bill\n";
        String dataToAppend = "2018/01/01, CREDIT, 200, 200, Got paid\n2018/01/02, DEBIT, 50, 150, Paid bill\n";
        FileIO fileIO = new FileIO();
        fileIO.write(dataToWrite, fileName);
        fileIO.append(dataToAppend, fileName);
        assertEquals(fileIO.read(fileName), dataToWrite + dataToAppend);
    }

}
