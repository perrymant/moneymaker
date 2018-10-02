package io.github.perrymant.moneymaker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelpFileTest {

    static final String HELPFILE = "./src/main/resources/moneymaker-help.txt";

    @Test
    public void canDisplayHelpInfo() {
        HelpFile helpFile = new HelpFile();
        assertEquals("Check contents of file!!!", helpFile.read(HELPFILE));
    }
}


