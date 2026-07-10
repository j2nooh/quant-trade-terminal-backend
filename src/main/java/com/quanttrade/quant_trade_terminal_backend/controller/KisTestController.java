package com.quanttrade.quant_trade_terminal_backend.controller;

import com.quanttrade.quant_trade_terminal_backend.client.KisPriceClient;
import com.quanttrade.quant_trade_terminal_backend.dto.KisPriceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KisTestController {
    // test controller

    private final KisPriceClient kisPriceClient;

    @GetMapping("/test/price/{stockCode}")
    public KisPriceResponse getPrice(@PathVariable String stockCode) {
        return kisPriceClient.getCurrentPrice(stockCode);
    }
}