package com.hollandandbarrett.paymentinfohandler.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {

    @JsonProperty("accountUid")
    private String accountUid;

    @JsonProperty("accountType")
    private AccountType accountType;

    @JsonProperty("defaultCategory")
    private String defaultCategory;

    @JsonProperty("currency")
    private Currency currency;

    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    @JsonProperty("name")
    private String name;

}
