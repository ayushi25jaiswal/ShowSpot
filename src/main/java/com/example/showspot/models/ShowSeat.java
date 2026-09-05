package com.example.showspot.models;

import com.example.showspot.models.enums.ShowSeatStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeat {
    private Show show;
    private Seat seat;
    private ShowSeatStatus showSeatStatus;

}
