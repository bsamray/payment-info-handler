package com.hollandandbarrett.paymentinfohandler.service;

import com.hollandandbarrett.paymentinfohandler.exception.BankApiException;
import com.hollandandbarrett.paymentinfohandler.model.Account;
import com.hollandandbarrett.paymentinfohandler.model.Accounts;
import com.hollandandbarrett.paymentinfohandler.model.SpendingData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

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
        logger.debug("Getting accounts associated with a requested access token");
        ResponseEntity<Accounts> responseEntity = restTemplate
                .exchange(baseUrl.concat(accountsUri), HttpMethod.GET, buildHeader(accessToken), Accounts.class);

        return Optional.ofNullable(responseEntity.getBody()).map(Accounts::getAccounts)
                .orElseThrow(() -> new BankApiException("Error while calling the Bank Accounts API"));
    }

    @Override
    public SpendingData getSpending(String accessToken, String accountId, String year, String month) {
        logger.debug("Getting spending for account ({}) pertaining year ({}} and month ({})", accountId, year, month);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl.concat(accountsUri)
                .concat("/").concat(accountId).concat(spendingUri))
                .queryParam("year", year)
                .queryParam("month", month);
        ResponseEntity<SpendingData> responseEntity = restTemplate.exchange(builder.toUriString(),
                HttpMethod.GET, buildHeader(accessToken), SpendingData.class);

        return Optional.ofNullable(responseEntity.getBody())
                .orElseThrow(() -> new BankApiException("Error while calling the Bank Get Spending API"));
    }

    private HttpEntity<String> buildHeader(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bearer ".concat(accessToken));
        return new HttpEntity<>(headers);
    }

}
