package com.hollandandbarrett.paymentinfohandler.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    @InjectMocks
    private PaymentService paymentService;

    @Mock
    private FinBodyProxy finBodyProxy;

    @Test
    public void shouldGetPreviousMonthSpending() {
        Double spending = paymentService.getPreviousMonthSpending("test");

        assertThat(spending).isEqualTo(10.0);
    }

}
