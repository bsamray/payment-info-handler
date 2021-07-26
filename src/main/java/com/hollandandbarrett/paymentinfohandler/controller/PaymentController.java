package com.hollandandbarrett.paymentinfohandler.controller;

import com.hollandandbarrett.paymentinfohandler.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigInteger;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    @Resource
    private PaymentService paymentService;

    @GetMapping("/out")
    public ResponseEntity<BigInteger> getTotalSpending() { // could have accepted a month name as @RequestParam if needed
        log.info("Received request to retrieve total spending");
        return ResponseEntity.ok(paymentService.getPreviousMonthSpending());
    }

}
