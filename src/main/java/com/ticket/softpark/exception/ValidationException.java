package com.ticket.softpark.exception;
public class ValidationException extends RuntimeException{

    public ValidationException(String mensagem) {
        super(mensagem);
    }
}
