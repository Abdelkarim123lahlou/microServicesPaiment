package com.ms.paimentms.services;

import com.ms.paimentms.dto.PaymentRequestDto;
import com.ms.paimentms.dto.PaymentResponseDto;

import java.util.List;

public interface PaymentService {
    PaymentResponseDto savePayment(PaymentRequestDto paymentRequestDto);
    PaymentResponseDto getPaymentById(int id);
    List<PaymentResponseDto> getAllPayments();
}
