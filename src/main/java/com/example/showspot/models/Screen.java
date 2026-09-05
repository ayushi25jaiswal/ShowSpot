package com.example.showspot.models;

import com.example.showspot.models.enums.Features;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Screen {
    private String name;
    private List<Seat> seats;
    private List<Features> featuresSupported;
}
