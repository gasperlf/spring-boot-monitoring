package net.ontopsolutions.reactive.services;

import reactor.core.publisher.Mono;
import yahoofinance.Stock;

public interface StockService {

    Mono<Stock> getStockWithoutHistorical(String symbol) ;

    Mono<Stock> getStockWithHistorical(String symbol) ;
}
