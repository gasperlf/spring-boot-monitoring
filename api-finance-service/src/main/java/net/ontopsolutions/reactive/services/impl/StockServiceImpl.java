package net.ontopsolutions.reactive.services.impl;

import net.ontopsolutions.reactive.datasource.ApiYahooClient;
import net.ontopsolutions.reactive.services.StockService;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;

import java.io.IOException;

@Service
public class StockServiceImpl implements StockService {

    private final ApiYahooClient apiYahooClient;

    public StockServiceImpl(ApiYahooClient apiYahooClient) {
        this.apiYahooClient = apiYahooClient;
    }

    public Stock getStockWithoutHistorical(String symbol) throws IOException {
        return apiYahooClient.getStock(symbol, false);
    }

    public Stock getStockWithHistorical(String symbol) throws IOException {
        return apiYahooClient.getStock(symbol, true);
    }
}
