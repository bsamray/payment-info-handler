package com.hollandandbarrett.paymentinfohandler.controller;

import com.hollandandbarrett.paymentinfohandler.service.BankIntermediary;
import com.hollandandbarrett.paymentinfohandler.service.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
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
    public void whenAccessTokenNotInHeader_shouldThrowBadRequest() throws Exception {

        when(paymentService.getPreviousMonthSpending(anyString())).thenReturn(1111.22);

        this.mockMvc.perform(get("/api/v1/payments/out"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenValidRequest_shouldReturnOkResponse() throws Exception {

        when(paymentService.getPreviousMonthSpending(anyString())).thenReturn(1111.22);

        this.mockMvc.perform(get("/api/v1/payments/out").header("access-token", "testToken"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{'total_spent': 1111.22}"));
    }


}
