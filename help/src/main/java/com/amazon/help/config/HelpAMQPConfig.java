package com.amazon.help.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelpAMQPConfig {

	public static String EXCHANGE_NAME = "Help";

	@Bean
	public Exchange declareExchange() {
		return ExchangeBuilder.directExchange(EXCHANGE_NAME).durable(true).build();
	}
}
