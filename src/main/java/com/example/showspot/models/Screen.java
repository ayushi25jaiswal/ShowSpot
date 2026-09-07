package com.example.showspot.models;

import com.example.showspot.models.enums.Features;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends  BaseModel{
    private String name;

    @OneToMany
    private List<Seat> seats;

    @Enumerated
    @ElementCollection
    private List<Features> featuresSupported;
}
