package com.hollandandbarrett.paymentinfohandler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpendingData {

    private String period;

    private Double totalSpent;

    private Double totalReceived;

    private Double netSpend;

    private Double totalSpendNetOut;

    private Double totalReceivedNetIn;

    private Currency currency;

    private Direction direction;

    private List<SpendingBreakdown> breakdown;

}
