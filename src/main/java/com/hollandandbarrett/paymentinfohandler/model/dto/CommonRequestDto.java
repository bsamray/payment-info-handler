package com.hollandandbarrett.paymentinfohandler.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonRequestDto {

    @JsonProperty("access_token")
    private String accessToken;

}
