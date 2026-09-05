package com.example.showspot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseModel{
    private String name;
    private int row;
    private int col;
    private SeatType seatType;
}
