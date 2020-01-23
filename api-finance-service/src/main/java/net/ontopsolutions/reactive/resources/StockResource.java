package net.ontopsolutions.reactive.resources;

import net.ontopsolutions.reactive.services.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yahoofinance.Stock;

import java.io.IOException;

@RestController
public class StockResource {

    private final StockService stockService;

    public StockResource(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping(path = "/stockWithoutHistorical",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Stock> getStockWithoutHistorical(String nameCompany)throws IOException {
       return ResponseEntity.status(HttpStatus.OK).body(stockService.getStockWithoutHistorical(nameCompany));
    }

    @GetMapping(path = "/stockWithHistorical",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Stock> getStockWithtHistorical(String nameCompany)throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(stockService.getStockWithHistorical(nameCompany));
    }
}
