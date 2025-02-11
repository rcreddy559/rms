package com.guest.controller;

import com.guest.model.GuestModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
public class GuestController {

    @Bean
    public RouterFunction<ServerResponse> guestRouter() {
        return RouterFunctions.route()
                .GET("/guests", this::getGuests)
                .GET("/guests/{guestId}", this::getGuest)
                .POST("/guests", this::save)
                .PUT("/guests/{guestId}", this::update)
                .DELETE("/guests/{guestId}", this::delte)
                .GET("/guests/email/{email}", this::getGuestByEmail)
                .build();
    }

    private Mono<ServerResponse> getGuests(ServerRequest request) {
        log.info("[START] get Guests");
        log.info("[END] get Guests");
        return Mono.empty();
    }

    private Mono<ServerResponse> getGuest(ServerRequest request) {
        log.info("[START] getGuest");
        var guestId = request.pathVariable("guestId");
        log.info("guestId: " + guestId);
        log.info("[END] getGuest");
        return Mono.empty();
    }

    private Mono<ServerResponse> save(ServerRequest request) {
        log.info("[START] save");
        Mono<GuestModel> guest = request.bodyToMono(GuestModel.class);
        Mono<GuestModel> guestSave = guest.map(g -> {
            g.setId(909090L);
            g.setEmail(g.getEmail() + "-save");
            return g;
        });
        log.info("[END] save");
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM).body(guestSave, GuestModel.class);
    }

    private Mono<ServerResponse> update(ServerRequest request) {
        log.info("[START] update");

        var guestId = request.pathVariable("guestId");
        log.info("guestId: " + guestId);
        Mono<GuestModel> guest = request.bodyToMono(GuestModel.class);
        log.info("guest: {}", guest);
        Mono<GuestModel> guestUpdated = guest.map(g -> {
            g.setId(Long.parseLong(guestId));
            return g;
        });
        log.info("[END] update");
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM).body(guestUpdated, GuestModel.class);
    }

    private Mono<ServerResponse> delte(ServerRequest request) {
        log.info("[START] delte");
        var guestId = request.pathVariable("guestId");
        log.info("guestId: " + guestId);
        log.info("[END] delte");
        return Mono.empty();
    }

    private Mono<ServerResponse> getGuestByEmail(ServerRequest request) {
        log.info("[START] delte");
        var email = request.pathVariable("email");
        log.info("email: " + email);
        log.info("[END] delte");
        Mono<GuestModel> guest = Mono.just(new GuestModel(1234L, "Name-Name-Name", email));
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(guest, GuestModel.class);
    }

}
