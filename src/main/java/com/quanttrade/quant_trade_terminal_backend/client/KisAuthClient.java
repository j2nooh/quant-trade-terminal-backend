package com.quanttrade.quant_trade_terminal_backend.client;

import com.quanttrade.quant_trade_terminal_backend.dto.KisTokenResponse;
import com.quanttrade.quant_trade_terminal_backend.property.KisProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class KisAuthClient {

    // 토큰 발급 및 캐싱

    private final WebClient kisWebClient;
    private final KisProperties properties;

    private String cachedToken;
    private LocalDateTime tokenExpiry;

    public synchronized String getAccessToken() {
        if (cachedToken != null && tokenExpiry != null && LocalDateTime.now().isBefore(tokenExpiry)) {
            return cachedToken; // 캐시된 토큰 재사용
        }
        return issueNewToken();
    }

    private String issueNewToken() {
        Map<String, String> body = Map.of(
                "grant_type", "client_credentials",
                "appkey", properties.appKey(),
                "appsecret", properties.appSecret()
        );

        KisTokenResponse response = kisWebClient.post()
                .uri(properties.tokenPath())
                .bodyValue(body)
                .retrieve()
                .bodyToMono(KisTokenResponse.class)
                .block();

        this.cachedToken = response.accessToken();
        // 만료 1분 여유를 두고 캐시 (동시성 안전하게)
        this.tokenExpiry = LocalDateTime.now().plusSeconds(response.expiresIn() - 60);
        return cachedToken;
    }
}