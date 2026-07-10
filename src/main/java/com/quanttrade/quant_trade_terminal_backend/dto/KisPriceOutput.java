package com.quanttrade.quant_trade_terminal_backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record KisPriceOutput (
        @JsonProperty("stck_prpr") String currentPrice,
        @JsonProperty("prdy_vrss") String priceChange,
        @JsonProperty("prdy_ctrt") String changeRate,
        @JsonProperty("acml_vol") String accumulatedVolume
){
    // 실제 시세 데이터 DTO (응답 기준으로, 진짜 시세 데이터는 'output' 안에 있음)
}
