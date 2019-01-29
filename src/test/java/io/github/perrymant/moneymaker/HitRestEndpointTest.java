package io.github.perrymant.moneymaker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HitRestEndpointTest {

    @Autowired
    private
    MockMvc mvc;

    @Test
    public void assertJSONResponse() {
        String targetJSON = "" +
                "{\n" +
                "  \"report\":[\n" +
                "    {\n" +
                "      \"date\":\"2018-01-01\",\n" +
                "      \"amount\":125,\n" +
                "      \"description\":\"Got paid\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"date\":\"2018-01-02\",\n" +
                "      \"amount\":-72,\n" +
                "      \"description\":\"Paid bill\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        try {
            mvc.perform(MockMvcRequestBuilders.get("/report"))
                    .andExpect(status().isOk())
                    .andExpect(content().string(equalTo(targetJSON)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
