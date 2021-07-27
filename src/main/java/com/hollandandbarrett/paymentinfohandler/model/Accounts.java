package com.hollandandbarrett.paymentinfohandler.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Accounts {

    @JsonProperty("accounts")
    private List<Account> accounts;

}