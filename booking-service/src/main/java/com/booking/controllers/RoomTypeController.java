package com.booking.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.booking.handler.RoomTypeHandler;
import com.booking.models.RoomTypeModel;

import reactor.core.publisher.Mono;

@Configuration
public class RoomTypeController {

    private static final String ROOM_TYPE_ID_PATHVARIABLE = "roomTypeId";

    private final RoomTypeHandler roomTypeHandler;

    private static final String ROOM_TYPE = "/roomtype";
    private static final String ROOM_TYPE_ID = "/{roomTypeId}";

    RoomTypeController(RoomTypeHandler roomTypeHandler) {
        this.roomTypeHandler = roomTypeHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> roomRouter() {
        return RouterFunctions.route()
                .GET(ROOM_TYPE, this::getRoomTypes)
                .GET(ROOM_TYPE + ROOM_TYPE_ID, this::getRoomType)
                .POST(ROOM_TYPE, this::save)
                .PUT(ROOM_TYPE + ROOM_TYPE_ID, this::update)
                .DELETE(ROOM_TYPE + ROOM_TYPE_ID, this::delete)
                .build();
    }

    public Mono<ServerResponse> getRoomTypes(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM)
                .body(roomTypeHandler.getRoomTypes(), String.class);
    }

    public Mono<ServerResponse> getRoomType(ServerRequest request) {
        var roomTypeId = request.pathVariable(ROOM_TYPE_ID_PATHVARIABLE);
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(roomTypeHandler.getRoomType(roomTypeId), String.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        var roomTypeModel = request.bodyToMono(RoomTypeModel.class);
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(roomTypeHandler.save(roomTypeModel), String.class);
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        var roomTypeId = request.pathVariable(ROOM_TYPE_ID_PATHVARIABLE);
        roomTypeHandler.delete(roomTypeId);
        return ServerResponse.ok().build();
    }

    public Mono<ServerResponse> update(ServerRequest request) {
        var roomTypeId = request.pathVariable(ROOM_TYPE_ID_PATHVARIABLE);
        var roomTypeModel = request.bodyToMono(RoomTypeModel.class);
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(roomTypeHandler.udate(roomTypeId, roomTypeModel), String.class);
    }
}
