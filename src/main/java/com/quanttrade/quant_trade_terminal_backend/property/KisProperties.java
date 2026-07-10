package com.quanttrade.quant_trade_terminal_backend.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kis")
public record KisProperties(
        String baseUrl,
        String appKey,
        String appSecret,
        String tokenPath,
        String pricePath
) {
    // 설정값을 읽어오는 클래스
    // @ConfigurationProperties 어노테이션을 사용하여 application.yml 또는 application.properties 파일에서 kis로 시작하는 설정값을 읽어와 자동으로 매핑해 준다.
}
