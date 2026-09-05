package com.example.showspot.models;

import com.example.showspot.models.enums.PaymentMode;
import com.example.showspot.models.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseModel{
    private int amount;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private String referenceId;
}
