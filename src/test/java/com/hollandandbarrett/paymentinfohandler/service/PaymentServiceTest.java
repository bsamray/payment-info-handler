package com.hollandandbarrett.paymentinfohandler.service;

import com.hollandandbarrett.paymentinfohandler.model.Account;
import com.hollandandbarrett.paymentinfohandler.model.SpendingData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    @InjectMocks
    private PaymentService paymentService;

    @Mock
    private FinBodyProxy finBodyProxy;

    @Test
    public void shouldGetPreviousMonthSpending() {
        SpendingData spending1 = new SpendingData();
        spending1.setTotalSpent(444.33);
        SpendingData spending2 = new SpendingData();
        spending2.setTotalSpent(111.22);

        Account acct1 = new Account();
        acct1.setAccountUid("acct1");
        Account acct2 = new Account();
        acct2.setAccountUid("acct2");

        when(finBodyProxy.getAccounts(anyString())).thenReturn(List.of(acct1, acct2));
        when(finBodyProxy.getSpending(anyString(), anyString(), anyString(), anyString()))
                .thenReturn(spending1).thenReturn(spending2);

        Double totalSpent = paymentService.getPreviousMonthSpending("test");

        assertThat(totalSpent).isEqualTo(555.55);
    }

}
