package com.hollandandbarrett.paymentinfohandler.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
public class BankIntermediaryTest {

    @InjectMocks
    private BankIntermediary bankIntermediary;

    @BeforeEach
    public void setup() {
        ReflectionTestUtils.setField(bankIntermediary, "restTemplate", new RestTemplate());
        ReflectionTestUtils.setField(bankIntermediary, "baseUrl", "https://api-sandbox.starlingbank.com");
        ReflectionTestUtils.setField(bankIntermediary, "accountsUri", "/api/v2/accounts");
        ReflectionTestUtils.setField(bankIntermediary, "spendingUri", "");
    }

    @Test
    public void whenEndPointWorks_shouldReturnAccounts() {
        bankIntermediary.getAccounts("test");
    }

}
