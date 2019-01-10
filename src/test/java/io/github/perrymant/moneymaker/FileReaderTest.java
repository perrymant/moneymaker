package io.github.perrymant.moneymaker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileReaderTest {

    @Test
    public void canDisplayHelpInfo() {
        assertEquals("Some Text", new FileReader().read("flatfile.txt"));
    }

    @Test
    public void canDisplay_report_seed_data_json() {
        String targetJSON = "" +
                "{\n" +
                "  \"report\":[\n" +
                "    {\n" +
                "      \"date\":\"2018-01-01\",\n" +
                "      \"amount\":125,\n" +
                "      \"balance\":125,\n" +
                "      \"description\":\"Got paid\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\":\"2018-01-02\",\n" +
                "      \"amount\":-72,\n" +
                "      \"balance\":53,\n" +
                "      \"description\":\"Paid bill\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        assertEquals(targetJSON, new FileReader().read("report_seed_data.json"));
    }


}


