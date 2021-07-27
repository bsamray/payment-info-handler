package com.hollandandbarrett.paymentinfohandler.service;

import com.hollandandbarrett.paymentinfohandler.model.Account;
import com.hollandandbarrett.paymentinfohandler.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

@Service
public class PaymentService implements PaymentServiceTemplate {

    private static final Logger log = LoggerFactory.getLogger(PaymentService.class);

    @Resource
    private FinBodyProxy finBodyProxy;

    @Override
    public Double getPreviousMonthSpending(String accessToken) {
        log.debug("Retrieving previous month spending from the bank");
        LocalDate now = LocalDate.now();
        Month month = Utils.getPreviousMonth(now);
        Year year = Utils.getYearOfPreviousMonth(now);
//
//        List<String> acctIds = finBodyProxy.getAccounts(accessToken).stream().map(Account::getAccountUid).peek(System.out::println)
//                .collect(Collectors.toList());
//        log.info("account size is ({})", acctIds.size());


        return finBodyProxy.getAccounts(accessToken).stream()
                .map(Account::getAccountUid)
                .map(acctId -> finBodyProxy.getSpending(accessToken, acctId,
                            String.valueOf(year), month.name()).getTotalSpent())
                .reduce(0.0, Double::sum);
    }

}
