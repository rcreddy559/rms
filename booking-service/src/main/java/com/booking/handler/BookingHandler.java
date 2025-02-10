package com.booking.handler;

import com.booking.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.booking.models.BookingModel;
import com.booking.models.BookingStatus;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookingHandler {

    final private Flux<BookingModel> bookings;

    BookingHandler() {
        bookings = Flux.range(0, 19)
                .map(i -> BookingModel.builder().bookingId(Long.valueOf(i)).bookingStatus(BookingStatus.CHECKED_IN)
                        .build());
    }

    public Flux<BookingModel> getBookings() {
        return bookings;
    }

    public Flux<BookingModel> getBooking(String bookingId) {
        final long id = Long.parseLong(bookingId);
        if (20 < id) {
            throw new ResourceNotFoundException("BookingHandler", "bookingId", id);
        }
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
