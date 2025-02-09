package com.booking.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class BookingModel {
    private Long bookingId;
    private Long guestId;
    private Long roomId;
    private Long roomTypeId;

    private LocalDate startDate;
    private LocalDate endDate;
    private Integer numberOfGuests;
    private BigDecimal totalPrice;
    private BookingStatus bookingStatus;

    private String confirmationNumber;
    private String cancellationPolicy;
    private LocalDateTime creationTimestamp;
    private LocalDateTime lastUpdatedTimestamp;
    private String specialRequests;
}
