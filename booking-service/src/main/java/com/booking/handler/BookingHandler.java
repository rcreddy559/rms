package com.booking.handler;

import org.springframework.stereotype.Service;

import com.booking.models.BookingModel;
import com.booking.models.BookingStatus;

import reactor.core.publisher.Flux;

@Service
public class BookingHandler {

    public Flux<BookingModel> getBookings() {
        return Flux.range(0, 19)
                .doOnNext(i -> System.out.println("processing count in stream flow : " + i))
                .map(i -> BookingModel.builder().bookingId(Long.valueOf(i)).bookingStatus(BookingStatus.CHECKED_IN)
                        .build());
    }
}
