package com.api_gateway_springBootApplication.Configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


// Note : E CustomFilter ane class just Pre-filter and Post-filter Concepect chudatanili rasamu anthe

// But real time project lo Spring Security ni implimnet cheyali

/*
    1. Pre-filter: means nothing but before sending the request to microservices if we done any
    validation or any kind of oparation we will call that Pre-filter.

    2. Post-filter: means nothing but after getting the response from microservices if we done any
    changes to the response or any kind of oparation we will call that Post-filter.
 */


@Configuration
public class CustomFilter implements GlobalFilter {

    Logger logger = LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();

        if (request.getURI().toString().contains("/api/student")) {

        }

        logger.info("pre-filter Authorization= " + request.getHeaders().getFirst("Authorization"));

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {

            ServerHttpResponse response = exchange.getResponse();

            logger.info("Post Filter = " + response.getStatusCode());
        }));

    }

}


