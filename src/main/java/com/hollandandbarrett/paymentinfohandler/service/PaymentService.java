package com.hollandandbarrett.paymentinfohandler.service;

import com.hollandandbarrett.paymentinfohandler.util.Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

@Service
public class PaymentService implements PaymentServiceTemplate {

    @Resource
    private FinBodyProxy finBodyProxy;

    @Override
    public Double getPreviousMonthSpending(String accessToken) {
        LocalDate now = LocalDate.now();
        Month month = Utils.getPreviousMonth(now);
        Year year = Utils.getYearOfPreviousMonth(now);

        return Double.valueOf(10);
    }

}
