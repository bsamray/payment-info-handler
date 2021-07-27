package com.hollandandbarrett.paymentinfohandler.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hollandandbarrett.paymentinfohandler.util.Utils;

public class TotalSpendDto {

    @JsonProperty("total_spent")
    private String totalSpent;

    public TotalSpendDto(Double totalSpent) {
        this.totalSpent = Utils.formatForAmountDisplay(totalSpent);
    }
}
