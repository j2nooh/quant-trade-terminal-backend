package com.quanttrade.quant_trade_terminal_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class QuantTradeTerminalBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuantTradeTerminalBackendApplication.class, args);
	}

}
