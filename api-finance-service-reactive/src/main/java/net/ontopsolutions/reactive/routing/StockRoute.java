package net.ontopsolutions.reactive.routing;

import net.ontopsolutions.reactive.routing.handler.StockHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.io.IOException;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class StockRoute {

    private final StockHandler stockHandler;

    public StockRoute(StockHandler stockHandler) {
        this.stockHandler = stockHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> route() throws IOException {
        return RouterFunctions
                .route(GET("/stockWithHistorical/{nameCompany}")
                        .and(accept(MediaType.APPLICATION_JSON)), stockHandler::getStockWithHistorical)
                .andRoute(GET("/stockWithoutHistorical/{nameCompany}")
                        .and(accept(MediaType.APPLICATION_JSON)), stockHandler::getStockWithoutHistorical)
                ;
    }

}
