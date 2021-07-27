package com.hollandandbarrett.paymentinfohandler.service;

import com.hollandandbarrett.paymentinfohandler.exception.BankApiException;
import com.hollandandbarrett.paymentinfohandler.model.Account;
import com.hollandandbarrett.paymentinfohandler.model.Accounts;
import com.hollandandbarrett.paymentinfohandler.model.SpendingData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BankIntermediaryTest {

    @InjectMocks
    private BankIntermediary bankIntermediary;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        ReflectionTestUtils.setField(bankIntermediary, "baseUrl", "https://api-sandbox.starlingbank.com");
        ReflectionTestUtils.setField(bankIntermediary, "accountsUri", "/api/v2/accounts");
        ReflectionTestUtils.setField(bankIntermediary, "spendingUri", "/spending-insights/country");
    }

    @Test
    public void whenEndPointWorks_shouldReturnAccounts() {
        Account account1 = new Account();
        account1.setAccountUid("acct1");
        Account account2 = new Account();
        account2.setAccountUid("acct2");
        Accounts accounts = new Accounts();
        accounts.setAccounts(List.of(account1, account2));

        when(restTemplate.exchange(eq("https://api-sandbox.starlingbank.com/api/v2/accounts"),
                eq(HttpMethod.GET), any(HttpEntity.class), eq(Accounts.class)))
                .thenReturn(ResponseEntity.ok(accounts));

        List<Account> accountList = bankIntermediary.getAccounts("test");

        assertThat(accountList).isNotNull();
        assertThat(accountList.size()).isEqualTo(2);
        assertThat(accountList.get(0).getAccountUid()).isEqualTo("acct1");
        assertThat(accountList.get(1).getAccountUid()).isEqualTo("acct2");
    }

    @Test
    public void whenAccountsEndPointReturnsNull_shouldThrowException() {
        when(restTemplate.exchange(eq("https://api-sandbox.starlingbank.com/api/v2/accounts"),
                eq(HttpMethod.GET), any(HttpEntity.class), eq(Accounts.class)))
                .thenReturn(ResponseEntity.ok(null));

        assertThrows(BankApiException.class, () -> bankIntermediary.getAccounts("test"));
    }

    @Test
    public void whenSpendingEndPointWorks_shouldReturnSpending() {
        SpendingData spendingData = new SpendingData();
        spendingData.setTotalSpent(1234.55);
        String url = "https://api-sandbox.starlingbank.com/api/v2/accounts/1/spending-insights/country?year=2021&month=JUNE";

        when(restTemplate
                .exchange(eq(url),
                eq(HttpMethod.GET), any(HttpEntity.class), eq(SpendingData.class)))
                .thenReturn(ResponseEntity.ok(spendingData));

        SpendingData spending = bankIntermediary.getSpending("test", "1", "2021", "JUNE");

        assertThat(spending).isNotNull();
        assertThat(spending.getTotalSpent()).isEqualTo(1234.55);
    }

    @Test
    public void whenSpendingEndPointReturnsNull_shouldThrowException() {
        String url = "https://api-sandbox.starlingbank.com/api/v2/accounts/1/spending-insights/country?year=2021&month=JUNE";

        when(restTemplate
                .exchange(eq(url),
                eq(HttpMethod.GET), any(HttpEntity.class), eq(SpendingData.class)))
                .thenReturn(ResponseEntity.ok(null));

        assertThrows(BankApiException.class, () -> bankIntermediary.getSpending("test", "1",
                "2021", "JUNE"));
    }

}
