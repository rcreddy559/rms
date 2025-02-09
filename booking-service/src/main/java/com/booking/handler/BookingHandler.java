package com.booking.handler;

import org.springframework.stereotype.Service;

import com.booking.models.BookingModel;
import com.booking.models.BookingStatus;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookingHandler {

    Flux<BookingModel> bookings;

    BookingHandler() {
        bookings = Flux.range(0, 19)
                .map(i -> BookingModel.builder().bookingId(Long.valueOf(i)).bookingStatus(BookingStatus.CHECKED_IN)
                        .build());
    }

    public Flux<BookingModel> getBookings() {
        return bookings;
    }

    public Flux<BookingModel> getBooking(String bookingId) {
        return Flux
                .just(BookingModel.builder().bookingId(Long.valueOf(bookingId)).bookingStatus(BookingStatus.CHECKED_IN)
                        .build());
    }

    public Mono<BookingModel> save(Mono<BookingModel> booking) {
        return booking;
    }

    public Mono<BookingModel> update(Long bookingId, Mono<BookingModel> booking) {
        return booking.map(b -> {
            b.setBookingId(bookingId);
            b.setBookingStatus(BookingStatus.CANCELLED);
            return b;
        });
    }

    public void delete(Long bookingId) {

    }

    public Flux<BookingModel> roomAvailability(String roomTypeId, String startDate, String endDate) {
        return bookings;
    }
}
