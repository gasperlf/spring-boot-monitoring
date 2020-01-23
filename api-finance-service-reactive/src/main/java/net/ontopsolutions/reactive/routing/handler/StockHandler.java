package net.ontopsolutions.reactive.routing.handler;

import lombok.extern.slf4j.Slf4j;
import net.ontopsolutions.reactive.services.StockService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import yahoofinance.Stock;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.Optional;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.ServerResponse.badRequest;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
@Component
public class StockHandler {

    private final StockService stockService;

    public StockHandler(StockService stockService) {
        this.stockService = stockService;
    }

    public Mono<ServerResponse> getStockWithHistorical(@NotNull ServerRequest serverRequest) {
        Optional<String> nameCompany = Optional.of(serverRequest.pathVariable("nameCompany"));
        Mono<Stock> response = stockService.getStockWithHistorical(nameCompany.get()).log();
        return response.flatMap(rta -> ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromValue(rta)))
                .switchIfEmpty(badRequest().build())
                .log();
    }

    public Mono<ServerResponse> getStockWithoutHistorical(@NotNull ServerRequest serverRequest) {
        Optional<String> nameCompany = Optional.of(serverRequest.pathVariable("nameCompany"));
        Mono<Stock> response = stockService.getStockWithoutHistorical(nameCompany.get()).log();
        return response.flatMap(rta -> ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromValue(rta)))
                .switchIfEmpty(badRequest().build())
                .log();
    }
}
