package com.booking.controllers;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.booking.handler.BookingHandler;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
public class BookingController {
    private final BookingHandler bookingHandler;

    public BookingController(BookingHandler bookingHandler) {
        this.bookingHandler = bookingHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> bookingRouter() {
        return RouterFunctions.route()
                .GET("/booking", this::getBookings)
                .build();
    }

    public Mono<ServerResponse> getBookings(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(bookingHandler.getBookings(), String.class);
    }

}
