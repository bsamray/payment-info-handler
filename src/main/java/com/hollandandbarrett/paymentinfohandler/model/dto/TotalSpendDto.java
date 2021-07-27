package com.hollandandbarrett.paymentinfohandler.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TotalSpendDto {

    @JsonProperty("total_spent")
    private Double totalSpent;

    public TotalSpendDto(Double totalSpent) {
        this.totalSpent = totalSpent;
    }
}
