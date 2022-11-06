package com.ms.paimentms.web;

import com.ms.paimentms.dto.PaymentRequestDto;
import com.ms.paimentms.dto.PaymentResponseDto;
import com.ms.paimentms.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "paymentApi")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping(path = "/savePayment")
    public PaymentResponseDto savePayment(PaymentRequestDto paymentRequestDto){
        return paymentService.savePayment(paymentRequestDto) ;
    }
    @GetMapping(path ="/payment/{idPayment}" )
    public PaymentResponseDto getPaymentById(@PathVariable(name = "id") int id){
        return paymentService.getPaymentById(id);
    }
    @GetMapping(path = "/Allpayments")
    public List<PaymentResponseDto> AllPayments(){

        return paymentService.getAllPayments();
    }
}