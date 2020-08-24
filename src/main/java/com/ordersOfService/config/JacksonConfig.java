package com.ordersOfService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ordersOfService.domain.PaymentByCard;
import com.ordersOfService.domain.PaymentBySlip;

@Configuration
public class JacksonConfig {
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				objectMapper.registerSubtypes(PaymentByCard.class);
				objectMapper.registerSubtypes(PaymentBySlip.class);
				super.configure(objectMapper);
			}
		};
		return builder;
	}
}
