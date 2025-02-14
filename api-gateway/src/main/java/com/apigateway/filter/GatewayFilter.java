package com.apigateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;


@Component
public class GatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("Global Pre Filter executed");
        ServerHttpRequest request = exchange.getRequest();
        System.out.println("getPath: "+request.getPath());
        
        return chain.filter(exchange).then(Mono.fromRunnable(()->{
            ServerHttpResponse response = exchange.getResponse();
            System.out.println("Global Post Filter executed Response Status code : "+ response.getStatusCode());
        }));
    }

    @Override
    public int getOrder() {
       return Ordered.LOWEST_PRECEDENCE;
    }

}
