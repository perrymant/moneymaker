package io.github.perrymant.moneymaker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
class Application {
    static final String ERROR_MESSAGE = "Error: Invalid argument: moneymaker help for more info.";
    private final Budget budget;
    private final FileReader reader = new FileReader();

    private final Logger logger;


    Application(Logger logger, TransactionMaker transactionMaker) {
        this.logger = logger;
        this.budget = new Budget(new Balance(), transactionMaker.getTransactions());
    }


    void start(String[] args) {
        if (args.length > 0) {
            if ("help".equals(args[0])) {
                logger.info(reader.read("moneymaker-help.txt"));
            } else if ("report".equals(args[0])) {
                logger.info(budget.report());
            } else if ("transaction".equals(args[0])) {
                budget.transaction(args);
            } else {
                logger.info(ERROR_MESSAGE);
            }
        } else {
            logger.info(ERROR_MESSAGE);
        }
    }

//    @GetMapping("/report")
//    public Map<String, String> mapReport() {
//        return budget.reportJSON();
//    }

/*
{
  "report": [
    {
      "dateTime": "2018-11-28T17:34:45Z",
      "amount": 1234,
      "balance": 12345678,
      "description": "blah"
    }
  ]
}
*/

    @GetMapping("/transaction")
    public void mapTransaction(String[] args) {
        budget.transaction(args);
    }


}