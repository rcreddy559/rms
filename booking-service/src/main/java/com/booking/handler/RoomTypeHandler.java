package com.booking.handler;

import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserter;

import com.booking.models.RoomTypeModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RoomTypeHandler {

    private Flux<RoomTypeModel> roomTypes;

    RoomTypeHandler() {
        roomTypes = Flux.range(0, 20).map(i -> RoomTypeModel.builder().roomTypeId(Long.valueOf(i)).build());
    }

    public Flux<RoomTypeModel> getRoomTypes() {
        return roomTypes;
    }

    public Mono<RoomTypeModel> save(Mono<RoomTypeModel> roomTypeModel) {
        return roomTypeModel;
    }

    public void delete(String roomTypeId) {

    }

    public Mono<RoomTypeModel> getRoomType(String roomTypeId) {
        return Mono.just(RoomTypeModel.builder().roomTypeId(Long.valueOf(roomTypeId)).build());
    }

    public Mono<RoomTypeModel> udate(String roomTypeId, Mono<RoomTypeModel> roomTypeModel) {
        return roomTypeModel.map(r -> {
            r.setRoomTypeId(Long.valueOf(roomTypeId));
            return r;
        });
    }

}
