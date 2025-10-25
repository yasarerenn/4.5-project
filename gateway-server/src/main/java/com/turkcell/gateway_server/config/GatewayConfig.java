package com.turkcell.gateway_server.config;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route("product-service", r -> r
                        .path("/api/v1/products/**")
                        .filters(f -> f
                                .retry(config -> config.setRetries(3)))
                        .uri("lb://product-service"))
                .route("fallback", r -> r
                        .path("/**")
                        .filters(f -> f.setStatus(HttpStatus.SC_NOT_FOUND))
                        .uri("no://op"))
                .build();
    }

}
