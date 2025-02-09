package com.booking.controllers;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.booking.handler.BookingHandler;
import com.booking.models.BookingModel;

import java.time.Duration;

import org.springframework.boot.context.ConfigurationWarningsApplicationContextInitializer.Check;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Configuration
public class BookingController {
    private final String BOOKING = "/booking";
    private final BookingHandler bookingHandler;

    public BookingController(BookingHandler bookingHandler) {
        this.bookingHandler = bookingHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> bookingRouter() {
        return RouterFunctions.route()
                .GET(BOOKING, this::getBookings)
                .GET(BOOKING + "/{bookingId}", this::getBooking)
                .POST(BOOKING, this::save)
                .PUT(BOOKING + "/{bookingId}", this::update)
                .GET(BOOKING + "availability?roomTypeId={roomTypeId}&startDate={startDate}&endDate={endDate}",
                        this::roomAvailability)
                .build();
    }

    public Mono<ServerResponse> getBookings(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(bookingHandler.getBookings(), String.class);
    }

    public Mono<ServerResponse> getBooking(ServerRequest serverRequest) {
        var bookingId = serverRequest.pathVariable("bookingId");
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(bookingHandler.getBooking(bookingId), String.class);
    }

    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        var booking = serverRequest.bodyToMono(BookingModel.class);
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(bookingHandler.save(booking), String.class);
    }

    public Mono<ServerResponse> update(ServerRequest serverRequest) {
        var bookingId = serverRequest.pathVariable("bookingId");
        var booking = serverRequest.bodyToMono(BookingModel.class);
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(bookingHandler.update(Long.valueOf(bookingId), booking), String.class);
    }

    public Mono<ServerResponse> delete(ServerRequest serverRequest) {
        var bookingId = serverRequest.pathVariable("bookingId");
        bookingHandler.delete(Long.valueOf(bookingId));
        return ServerResponse.ok().build();
    }

    public Mono<ServerResponse> roomAvailability(ServerRequest serverRequest) {
        var roomTypeId = serverRequest.pathVariable("roomTypeId");
        var startDate = serverRequest.pathVariable("startDate");
        var endDate = serverRequest.pathVariable("endDate");
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(bookingHandler.roomAvailability(roomTypeId, startDate, endDate), String.class);
    }
}
