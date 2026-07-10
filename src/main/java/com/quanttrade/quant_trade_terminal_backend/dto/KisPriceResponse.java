package com.quanttrade.quant_trade_terminal_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record KisPriceResponse (
        KisPriceOutput output,
        @JsonProperty("rt_cd") String returnCode,
        @JsonProperty("msg_cd") String messageCode,
        String msg1
) {
    // 전체 응답 껍데기 DTO (응답 기준으로 'output' 바깥쪽에는 요청이 성공했는지를 나타내는 공통 응답 껍데기가 있다.

}
