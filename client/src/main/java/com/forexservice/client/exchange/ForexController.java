package com.forexservice.client.exchange;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ForexController {

    @GetMapping("/currency-exchange-dto/from/{from}/to/{to}")
    ExchangeDto retrieveExchangeValueDto(@PathVariable String from, @PathVariable String to);
}
