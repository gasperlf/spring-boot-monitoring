package net.ontopsolutions.reactive.datasource.impl;

import lombok.SneakyThrows;
import net.ontopsolutions.reactive.datasource.ApiYahooClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@Service
public class ApiYahooClientImpl implements ApiYahooClient {
    
    @SneakyThrows
    public Mono<Stock> getStock(String symbol, boolean includeHistorical)  {
        return Mono.justOrEmpty(YahooFinance.get(symbol,includeHistorical));
    }
}
