package com.hollandandbarrett.paymentinfohandler.service;

import com.hollandandbarrett.paymentinfohandler.model.SpendingByCountry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BankIntermediary implements FinBodyProxy {

    private static final Logger logger = LoggerFactory.getLogger(BankIntermediary.class);

    @Resource
    private RestTemplate restTemplate;

    @Override
    public List<String> getAccounts(String accessToken) {
        return List.of();
    }

    @Override
    public SpendingByCountry getSpendingByCountry(String accessToken, String accountId, String year, String month) {
        logger.info("Getting spending for account ({}) pertaining year ({}} and month ({})", accountId, year, month);
        return null;
    }

}
