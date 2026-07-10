package com.quanttrade.quant_trade_terminal_backend.config;

import com.quanttrade.quant_trade_terminal_backend.property.KisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient kisWebClient(KisProperties properties) {
       return WebClient.builder().baseUrl(properties.baseUrl()).build();
    }
}
