package springbootmicroserviceforexservice;

import com.forexservice.client.exchange.ExchangeDto;
import com.forexservice.client.exchange.ForexController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexControllerImpl implements ForexController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){

        ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);

        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        return exchangeValue;
    }

    @Override
    public ExchangeDto retrieveExchangeValueDto(String from, String to) {

        ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);

        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        ExchangeDto dto = new ExchangeDto(
                exchangeValue.getId(),
                exchangeValue.getFrom(),
                exchangeValue.getTo(),
                exchangeValue.getConversionMultiple());
        dto.setPort(exchangeValue.getPort());

        return dto;
    }
}
