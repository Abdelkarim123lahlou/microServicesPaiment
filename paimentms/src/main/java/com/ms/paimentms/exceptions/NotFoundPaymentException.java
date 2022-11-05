package com.ms.paimentms.exceptions;

public class NotFoundPaymentException extends RuntimeException {
    public NotFoundPaymentException(String message) {
        super(message);
    }
}
