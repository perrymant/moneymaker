package io.github.perrymant.moneymaker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileReaderTest {

    @Test
    public void canDisplayHelpInfo() {
        assertEquals("Some Text", new FileReader().read("flatfile.txt"));
    }
}


