package com.quanttrade.quant_trade_terminal_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record KisTokenResponse(
        @JsonProperty("access_token") String accessToken,
        @JsonProperty("token_type") String tokenType,
        @JsonProperty("expires_in") int expiresIn
) {
    // 토큰 응답 DTO
}
