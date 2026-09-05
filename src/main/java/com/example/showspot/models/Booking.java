package com.example.showspot.models;

import com.example.showspot.models.enums.BookingStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Booking extends BaseModel{
    private User bookedBy;
    private List<ShowSeat> showSeats;
    private BookingStatus bookingStatus;
    private int amount;
    private List<Payment> payments;

}
