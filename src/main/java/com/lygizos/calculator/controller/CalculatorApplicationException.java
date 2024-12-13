package com.lygizos.calculator.controller;

import org.springframework.http.HttpStatus;

/**
 * Handle API user-friendly errors
 */
public class CalculatorApplicationException
{
    private final HttpStatus status;
    private final Integer httpCode;
    private String message;
    private String debugMessage;

    public CalculatorApplicationException(HttpStatus status) {
        this.status = status;
        this.httpCode = status.value();
    }

    public CalculatorApplicationException(HttpStatus status, String message) {
        this.status = status;
        this.httpCode = status.value();
        this.message = message;
    }

    public CalculatorApplicationException(HttpStatus status, Throwable cause) {
        this.status = status;
        this.httpCode = status.value();
        this.message = "Unexpected error";
        this.debugMessage = cause.getLocalizedMessage();
    }

    public CalculatorApplicationException(
        HttpStatus status, String message, Throwable cause
    ) {
        this.status = status;
        this.httpCode = status.value();
        this.message = message;
        this.debugMessage = cause.getLocalizedMessage();
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Integer getHttpCode() {
        return httpCode;
    }
}
