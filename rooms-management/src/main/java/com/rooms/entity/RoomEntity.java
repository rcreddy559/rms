package com.rooms.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class RoomEntity {
    
    @Id
    @Generated(value = "increment")
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
