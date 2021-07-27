package com.hollandandbarrett.paymentinfohandler.controller;

import com.hollandandbarrett.paymentinfohandler.model.dto.CommonRequestDto;
import com.hollandandbarrett.paymentinfohandler.model.dto.TotalSpendDto;
import com.hollandandbarrett.paymentinfohandler.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    @Resource
    private PaymentService paymentService;

    @GetMapping("/out")
    public ResponseEntity<TotalSpendDto> getTotalSpending(@RequestHeader(name = "access-token") String accessToken) {
        log.debug("Received request to retrieve total spending");
        TotalSpendDto totalSpendDto = new TotalSpendDto(paymentService.getPreviousMonthSpending(accessToken));
        return ResponseEntity.ok(totalSpendDto);
    }

}
