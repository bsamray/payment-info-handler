package com.hollandandbarrett.paymentinfohandler.service;

import com.hollandandbarrett.paymentinfohandler.model.Account;
import com.hollandandbarrett.paymentinfohandler.model.SpendingData;

import java.util.List;

public interface FinBodyProxy {

    List<Account> getAccounts(String accessToken);

    SpendingData getSpending(String accessToken, String accountId, String year, String month);

}
