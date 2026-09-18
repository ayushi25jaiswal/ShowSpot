package com.example.showspot.dtos;

import com.example.showspot.models.Booking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookingResponseDto {

    private Booking booking;
    private ResponseStatus responseStatus;
}
