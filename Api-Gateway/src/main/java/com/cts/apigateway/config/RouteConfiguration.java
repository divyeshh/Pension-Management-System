package com.cts.apigateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cts.apigateway.filter.LoggingFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class RouteConfiguration {
	
	@Autowired
	private LoggingFilter filter;

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		log.info("in global config");
		return builder.routes()
				.route(p -> p.path("/authorization-service/**").filters(f -> f.filter(filter)).uri("lb://authorization-service"))
				//.route(p -> p.path("/pensioner-detail-service/**").filters(f -> f.filter(filter)).uri("lb://pensioner-detail-service"))
				.route(p -> p.path("/pension-disbursement-service/**").filters(f -> f.filter(filter)).uri("lb://pension-disbursement-service"))
				.route(p -> p.path("/process-pension-service/**").filters(f -> f.filter(filter)).uri("lb://process-pension-service"))
				.build();
	}

}