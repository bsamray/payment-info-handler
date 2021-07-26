package com.hollandandbarrett.paymentinfohandler.service;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class PaymentService implements PaymentServiceTemplate {


    @Override
    public BigInteger getPreviousMonthSpending() {
        return BigInteger.valueOf(1); // TODO remove hard coding
    }
}
