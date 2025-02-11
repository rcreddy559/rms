package com.guest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class GuestModel {
    private Long id;
    private String name;
    private String email;
}