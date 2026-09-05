package com.example.showspot.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseModel{
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
}
