package com.example.showspot.models;

import com.example.showspot.models.enums.Features;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Show extends BaseModel{
    private Screen screen;
    private Movie movie;
    private Date startTime;
    private Date endTime;
    private List<Features> features;

}
