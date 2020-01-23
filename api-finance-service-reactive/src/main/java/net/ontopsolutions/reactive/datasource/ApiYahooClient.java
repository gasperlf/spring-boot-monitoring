package net.ontopsolutions.reactive.datasource;

import reactor.core.publisher.Mono;
import yahoofinance.Stock;

public interface ApiYahooClient {
    Mono<Stock> getStock(String nameCompany, boolean includeHistorical) ;
}
