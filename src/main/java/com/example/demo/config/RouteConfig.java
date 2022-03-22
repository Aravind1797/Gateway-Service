package com.example.demo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder)
    {
        return routeLocatorBuilder.routes()
                .route("PostApp", rt -> rt.path("/api/v1/posts//post/{id}")
                        .uri("http://localhost:3010/"))
                .route("Comment", rt -> rt.path("Post/{post id}/**")
                        .uri("http://localhost:3015/"))
                .route("Like", rt -> rt.path("/PostOrComment**")
                        .uri("http://localhost:3020/"))
                .build();

    }
}