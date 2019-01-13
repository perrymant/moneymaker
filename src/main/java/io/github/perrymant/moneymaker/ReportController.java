package io.github.perrymant.moneymaker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    @GetMapping("/report")
    public String report() {
        FileReader reader = new FileReader();
        return reader.read("report_seed_data.json");
    }

}
