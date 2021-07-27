package com.hollandandbarrett.paymentinfohandler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpendingBreakdown {

    private Country countryCode;

    private Double totalSpent;

    private Double totalReceived;

    private Double netSpend;

    private Double netDirection;

    private Currency currency;

    private Integer percentage;

    private Integer transactionCount;

}
