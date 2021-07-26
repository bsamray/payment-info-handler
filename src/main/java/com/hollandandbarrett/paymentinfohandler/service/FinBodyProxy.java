package com.hollandandbarrett.paymentinfohandler.service;

import com.hollandandbarrett.paymentinfohandler.model.SpendingByCountry;

import java.util.List;

public interface FinBodyProxy {

    List<String> getAccounts(String accessToken);

    SpendingByCountry getSpendingByCountry(String accessToken, String accountId, String year, String month);

}
