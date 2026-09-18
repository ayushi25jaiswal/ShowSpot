package com.example.showspot.models;

import com.example.showspot.models.enums.PaymentMode;
import com.example.showspot.models.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private int amount;
    @Enumerated
    private PaymentMode paymentMode;

    @Enumerated
    private PaymentStatus paymentStatus;
    private String referenceId;
}
