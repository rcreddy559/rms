package com.booking.models;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class RoomTypeModel {

    private Long roomTypeId;
    private String name;
    private String code;
    private String description;
    private Integer capacity;
    private String bedConfiguration;
    private String size; // e.g., "300 sq ft"
    private BigDecimal defaultBasePrice;
    private String amenities; // Could be a comma-separated string or JSON
    private String imageUrl;
}
