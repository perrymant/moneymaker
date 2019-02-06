package io.github.perrymant.moneymaker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GetReportTest {

    private static final String BASE_URL = "/report";

    @Autowired
    private MockMvc mvc;

    @Test
    public void assertJSONResponse() throws Exception {
        mvc.perform(get(BASE_URL).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.report[0].date", is("2018-01-01")))
                .andExpect(jsonPath("$.report[0].amount", is(125)))
                .andExpect(jsonPath("$.report[0].description", is("Got paid")))
                .andExpect(jsonPath("$.report[1].date", is("2018-01-02")))
                .andExpect(jsonPath("$.report[1].amount", is(-72)))
                .andExpect(jsonPath("$.report[1].description", is("Paid bill")))
                .andReturn();
    }

}