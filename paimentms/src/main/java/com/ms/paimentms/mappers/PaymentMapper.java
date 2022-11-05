package com.ms.paimentms.mappers;

import com.ms.paimentms.dto.PaymentRequestDto;
import com.ms.paimentms.dto.PaymentResponseDto;
import com.ms.paimentms.entities.Paiment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    Paiment paymentFromPaymentRequest(PaymentRequestDto paymentRequestDto);
    PaymentResponseDto paymentResponseFromPaymant(Paiment paiment);

}
