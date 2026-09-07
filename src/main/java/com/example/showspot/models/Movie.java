package com.example.showspot.models;

import com.example.showspot.models.enums.Features;
import com.example.showspot.models.enums.Languages;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    private List<Features> featuresList;
    private List<Languages> languages;
    private int duration;
    private int rating;

}
