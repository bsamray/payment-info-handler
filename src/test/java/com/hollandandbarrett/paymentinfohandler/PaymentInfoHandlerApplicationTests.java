package com.hollandandbarrett.paymentinfohandler;

import static org.assertj.core.api.Assertions.assertThat;

import com.hollandandbarrett.paymentinfohandler.controller.PaymentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentInfoHandlerApplicationTests {

	@Autowired
	private PaymentController paymentController;

	@Test
	void contextLoads() {
		assertThat(paymentController).isNotNull();
	}

}
