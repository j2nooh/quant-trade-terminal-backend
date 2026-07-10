package com.quanttrade.quant_trade_terminal_backend.client;

import com.quanttrade.quant_trade_terminal_backend.property.KisProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class KisPriceClient {
    // 현재가 조회

    private final WebClient kisWebClient;
    private final KisProperties properties;
    private final KisAuthClient kisAuthClient;

    public String getCurrentPrice(String stockCode) {
        String token = kisAuthClient.getAccessToken();

        return kisWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(properties.pricePath())
                        .queryParam("FID_COND_MRKT_DIV_CODE", "J")
                        .queryParam("FID_INPUT_ISCD", stockCode)
                        .build())
                .header("authorization", "Bearer " + token)
                .header("appkey", properties.appKey())
                .header("appsecret", properties.appSecret())
                .header("tr_id", "FHKST01010100")
                .header("custtype", "P")
                .retrieve()
                .bodyToMono(String.class) // 일단 String으로 받고, 나중에 DTO로 바꿔도 됨
                .block();
    }
}