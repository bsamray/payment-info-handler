package com.hollandandbarrett.paymentinfohandler.model;

import lombok.Data;

@Data
public class SpendingCountryBreakdown {

    private Country countryCode;

    private Double totalSpent;

    private Double totalReceived;

    private Double netSpend;

    private Double netDirection;

    private Currency currency;

    private Integer percentage;

    private Integer transactionCount;
}
