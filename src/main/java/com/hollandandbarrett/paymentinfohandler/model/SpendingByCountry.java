package com.hollandandbarrett.paymentinfohandler.model;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class SpendingByCountry {

    private String period;

    private Double totalSpent;

    private Double totalReceived;

    private Double netSpend;

    private Double totalSpendNetOut;

    private Double totalReceivedNetIn;

    private Currency currency;

    private Direction direction;

    private List<SpendingCountryBreakdown> breakdown;

}
