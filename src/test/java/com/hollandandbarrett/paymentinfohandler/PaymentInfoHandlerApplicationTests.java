package com.hollandandbarrett.paymentinfohandler;

import com.hollandandbarrett.paymentinfohandler.controller.PaymentController;
import com.hollandandbarrett.paymentinfohandler.service.FinBodyProxy;
import com.hollandandbarrett.paymentinfohandler.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PaymentInfoHandlerApplicationTests {

	@Resource
	private PaymentController paymentController;

	@Resource
	private PaymentService paymentService;

	@Resource
	private FinBodyProxy finBodyProxy;

	@Resource
	private RestTemplate restTemplate;

	@Test
	void contextLoads() {
		assertThat(paymentController).isNotNull();
		assertThat(paymentService).isNotNull();
		assertThat(finBodyProxy).isNotNull();
		assertThat(restTemplate).isNotNull();
	}

}
