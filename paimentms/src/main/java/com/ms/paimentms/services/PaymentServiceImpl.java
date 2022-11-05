package com.ms.paimentms.services;

import com.ms.paimentms.dto.PaymentRequestDto;
import com.ms.paimentms.dto.PaymentResponseDto;
import com.ms.paimentms.entities.Paiment;
import com.ms.paimentms.exceptions.NotFoundPaymentException;
import com.ms.paimentms.mappers.PaymentMapper;
import com.ms.paimentms.repositories.PaymentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    private PaymentRepo paymentRepo;
    private PaymentMapper paymentMapper;

    public PaymentServiceImpl(PaymentRepo paymentRepo, PaymentMapper paymentMapper) {
        this.paymentRepo = paymentRepo;
        this.paymentMapper = paymentMapper;
    }

    @Override
    public PaymentResponseDto savePayment(PaymentRequestDto paymentRequestDto) {
        Paiment paiment = paymentMapper.paymentFromPaymentRequest(paymentRequestDto);
        Paiment paimentComm = paymentRepo.save(paiment);

        return paymentMapper.paymentResponseFromPaymant(paimentComm);
    }

    @Override
    public PaymentResponseDto getPaymentById(int id) {
        Optional<Paiment> paiment = paymentRepo.findById(id);

        if (!paiment.isPresent()) throw  new NotFoundPaymentException("le payment dont vous avez consulté n'existe pas");

        return paymentMapper.paymentResponseFromPaymant(paiment.get());
    }

    @Override
    public List<PaymentResponseDto> getAllPayments() {
    List<Paiment> allPayments = paymentRepo.findAll();

        return  allPayments.stream()
                .map(paiment -> paymentMapper.paymentResponseFromPaymant(paiment))
                .collect(Collectors.toList());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
