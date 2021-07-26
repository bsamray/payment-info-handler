package com.hollandandbarrett.paymentinfohandler.controller;

import com.hollandandbarrett.paymentinfohandler.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigInteger;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaymentService paymentService;

    @Test
    public void shouldReturnSpending() throws Exception {

        when(paymentService.getPreviousMonthSpending()).thenReturn(BigInteger.valueOf(1111));

        this.mockMvc.perform(get("/api/v1/payments/out"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("1111"));
    }


}
