package com.lygizos.calculator.controller;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.logging.Logger;

@Order (Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler
{
    private static final java.util.logging.Logger LOGGER = Logger.getLogger(MyExceptionHandler.class.getSimpleName());

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleMethodArgument(
            Exception exception
    ) {
        Supplier<String> warningMessageSupplier = getWarningMessageStackTraceFromException(exception);
        LOGGER.warning(warningMessageSupplier);
        CalculatorApplicationException cae = new CalculatorApplicationException(HttpStatus.BAD_REQUEST);
        cae.setMessage("Unexpected error");
        cae.setDebugMessage(exception.getLocalizedMessage());
        return buildResponseEntity(cae);
    }

    private Supplier<String> getWarningMessageStackTraceFromException(Exception ex) {
        return () -> {
            StringBuilder sb = new StringBuilder(String.format("=== Error [%s] occurred === \nSTACKTRACE:\n", ex.getMessage().toUpperCase()));
            Arrays.stream(ex.getStackTrace()).forEach(stackTraceElement -> {
                sb.append("\nAT ClassName: ");
                sb.append(stackTraceElement.getClassName());
                sb.append(", and METHOD: ");
                sb.append(stackTraceElement.getMethodName());
                sb.append(String.format(" (loc:%d)", stackTraceElement.getLineNumber()));
            });
            return sb.toString();
        };
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?> handleOtherExceptions(
            ArithmeticException exception
    ) {
        CalculatorApplicationException cae = new CalculatorApplicationException(HttpStatus.BAD_REQUEST, exception.getLocalizedMessage());
        return buildResponseEntity(cae);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String error = "Malformed JSON request";
        return buildResponseEntity(new CalculatorApplicationException(HttpStatus.BAD_REQUEST, error, ex));
    }

    private ResponseEntity<Object> buildResponseEntity(CalculatorApplicationException apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
