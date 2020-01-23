package net.ontopsolutions.reactive.datasource.impl;

import net.ontopsolutions.reactive.datasource.ApiYahooClient;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

@Service
public class ApiYahooClientImpl implements ApiYahooClient {
    
    public Stock getStock(String symbol, boolean includeHistorical) throws IOException {
        return YahooFinance.get(symbol,includeHistorical);
    }
}
