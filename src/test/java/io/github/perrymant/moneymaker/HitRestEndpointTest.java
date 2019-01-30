package io.github.perrymant.moneymaker;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.contains;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HitRestEndpointTest {

    @Autowired
    private MockMvc mvc;

    private static final String BASE_URL = "/report";

    @Ignore
    @Test
    public void assertJSONResponse1() throws Exception {
        mvc.perform(get(BASE_URL).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.report", contains(125)))
                .andReturn();
    }

    @Test
    public void assertJSONResponse2() throws Exception {
        this.mvc.perform(get(BASE_URL)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Got paid")));
    }

}