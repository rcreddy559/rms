package com.guest.handler;

import org.springframework.stereotype.Service;
import com.guest.model.GuestModel;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class GuestHandler {

    Flux<GuestModel> guests;

    GuestHandler() {
        guests = Flux.range(0, 20)
                .map(i -> new GuestModel(Long.valueOf(i), "Name-" + i, "Email-" + i));
    }

    public Flux<GuestModel> getGuests() {
        log.info("[START] getGuests");

        log.info("[END] getGuests");
        return guests;
    }

    public Mono<GuestModel> getGuest(String guestId) {
        return guests.filter(g -> g.getId().equals(Long.valueOf(guestId))).next();
    }

    public Mono<GuestModel> save(Mono<GuestModel> guest) {
        log.info("[START] getGuests");
        guests.mergeWith(guest);
        final String[] email = new String[1];
        log.info("[END] getGuests");
        return guest;
    }

}
