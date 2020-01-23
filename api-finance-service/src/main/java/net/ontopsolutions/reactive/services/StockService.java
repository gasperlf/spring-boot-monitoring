package net.ontopsolutions.reactive.services;

import yahoofinance.Stock;

import java.io.IOException;

public interface StockService {

    Stock getStockWithoutHistorical(String symbol) throws IOException;

    Stock getStockWithHistorical(String symbol) throws IOException;
}
