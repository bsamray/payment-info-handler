package com.hollandandbarrett.paymentinfohandler.service;

import com.hollandandbarrett.paymentinfohandler.model.Account;
import com.hollandandbarrett.paymentinfohandler.model.Accounts;
import com.hollandandbarrett.paymentinfohandler.model.SpendingByCountry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class BankIntermediary implements FinBodyProxy {

    private static final Logger logger = LoggerFactory.getLogger(BankIntermediary.class);

    @Value("${application.endpoint.bank.baseurl}")
    private String baseUrl;

    @Value("${application.endpoint.bank.accounts}")
    private String accountsUri;

    @Value("${application.endpoint.bank.spending}")
    private String spendingUri;

    @Resource
    private RestTemplate restTemplate;

    @Override
    public List<Account> getAccounts(String accessToken) {


        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bearer ".concat(accessToken));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Account[]> responseEntity = restTemplate
                .exchange(baseUrl.concat(accountsUri), HttpMethod.GET, entity, Account[].class);

        return Arrays.asList(responseEntity.getBody());
    }

    @Override
    public SpendingByCountry getSpendingByCountry(String accessToken, String accountId, String year, String month) {
        logger.info("Getting spending for account ({}) pertaining year ({}} and month ({})", accountId, year, month);
        return null;
    }

}
