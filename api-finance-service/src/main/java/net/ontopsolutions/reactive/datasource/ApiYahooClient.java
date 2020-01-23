package net.ontopsolutions.reactive.datasource;

import yahoofinance.Stock;

import java.io.IOException;

public interface ApiYahooClient {
    Stock getStock(String nameCompany, boolean includeHistorical) throws IOException;
}
