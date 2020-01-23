package net.ontopsolutions.reactive.services.impl;

import net.ontopsolutions.reactive.datasource.ApiYahooClient;
import net.ontopsolutions.reactive.services.StockService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import yahoofinance.Stock;

@Service
public class StockServiceImpl implements StockService {

    private final ApiYahooClient apiYahooClient;

    public StockServiceImpl(ApiYahooClient apiYahooClient) {
        this.apiYahooClient = apiYahooClient;
    }

    public Mono<Stock> getStockWithoutHistorical(String symbol)  {
        return apiYahooClient.getStock(symbol, false);
    }

    public Mono<Stock> getStockWithHistorical(String symbol) {
        return apiYahooClient.getStock(symbol, true);
    }
}
