package io.github.perrymant.moneymaker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/jsontest")
    public String jsontest() {
        return "" +
                "{\n" +
                "  \"report\": [\n" +
                "    {\n" +
                "      \"dateTime\": \"2018-01-01T00:00:01Z\",\n" +
                "      \"amount\": 125,\n" +
                "      \"balance\": 125,\n" +
                "      \"description\": \"Got Paid\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"dateTime\": \"2018-01-01T00:00:02Z\",\n" +
                "      \"amount\": 125,\n" +
                "      \"balance\": 250,\n" +
                "      \"description\": \"Got Paid\"\n" +
                "    },\n" +
                "        {\n" +
                "      \"dateTime\": \"2018-01-02T00:00:03Z\",\n" +
                "      \"amount\": -72,\n" +
                "      \"balance\": 178,\n" +
                "      \"description\": \"Paid Bill\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }
}
