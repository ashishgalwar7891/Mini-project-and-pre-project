package com.example.apigw.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class applicationConfig {
    @Bean
    public RouteLocator getroute(RouteLocatorBuilder builder)
    {
        return builder.routes()
                .route(p->p
                        .path("/api/auth-user/**")
                        .uri("http://localhost:6666/*")
                )
                .route(p->p
                        .path("/api/product-app/**")
                        .uri("http://localhost:7777/*"))
                .build();
    }
}
