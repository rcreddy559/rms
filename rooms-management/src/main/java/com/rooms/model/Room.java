package com.rooms.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Room {
    private Long id;
    private String roomNumber;
    private String price;
    private String roomType;
    private String bedInfo;
    private String roomSize;
    private String roomView;
    private String roomStatus;
    private String roomFloor;
    private String roomDescription;
    private String roomCapacity;
    private String roomImage;
    private String roomRating;
    private String roomReview;
    private String roomAmenities;
    private String roomServices;
    private String roomFacilities;
    private String roomPolicies;
    private String roomCancellationPolicies;
    private String roomCheckIn;
    private String roomCheckOut;
}
