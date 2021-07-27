package com.hollandandbarrett.paymentinfohandler.model;

import java.util.List;

public class SpendingByCountry {

    private String period;

    private Double totalSpent;

    private Double totalReceived;

    private Double netSpend;

    private Double totalSpendNetOut;

    private Double totalReceivedNetIn;

    private Currency currency;

    private Direction direction;

    private List<SpendingBreakdown> breakdown;

    public Double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(Double totalSpent) {
        this.totalSpent = totalSpent;
    }
}
