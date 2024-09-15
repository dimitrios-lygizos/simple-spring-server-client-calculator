package com.lygizos.calculator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Supplier;
import java.util.logging.Logger;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private static final java.util.logging.Logger LOGGER = Logger.getLogger(RestController.class.getSimpleName());
    private final CalculationsService calculationService;

    public RestController(CalculationsService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public ResponseContentDto add(
            @RequestBody RequestContentDto request
    ) {
        return new ResponseContentDto(calculationService.doAdd(request.x(), request.y()));
    }

    @PostMapping("/multiply")
    @ResponseStatus(HttpStatus.OK)
    public ResponseContentDto multiply(
            @RequestBody RequestContentDto request
    ) {
        return new ResponseContentDto(calculationService.doMulti(request.x(), request.y()));
    }

    @PostMapping("/divide")
    @ResponseStatus(HttpStatus.OK)
    public ResponseContentDto div(
            @RequestBody RequestContentDto request
    ) {
        return new ResponseContentDto(calculationService.doDivide(request.x(), request.y()));
    }

    @PostMapping("/subtract")
    @ResponseStatus(HttpStatus.OK)
    public ResponseContentDto subtract(
            @RequestBody RequestContentDto request
    ) {
        return new ResponseContentDto(calculationService.doSubtract(request.x(), request.y()));
    }

    @PostMapping("/modulo")
    @ResponseStatus(HttpStatus.OK)
    public ResponseContentDto modulo(
            @RequestBody RequestContentDto request
    ) {
        return new ResponseContentDto(calculationService.doModulo(request.x(), request.y()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgument(
            MethodArgumentNotValidException exception
    ) {
        var errors = new HashMap<String, String>();
        exception.getBindingResult().getAllErrors().forEach(
                error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.putIfAbsent(fieldName,errorMessage);
                });
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleOtherExceptions(
            Exception exception
    ) {
        Supplier<String> warningMessageSupplier = getWarningMessageStackTraceFromException(exception);
        LOGGER.warning(warningMessageSupplier);
        var errors = new HashMap<String, String>();
        errors.putIfAbsent("Error Message", exception.getMessage());
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }

    private Supplier<String> getWarningMessageStackTraceFromException(Exception ex) {
        return () -> {
            StringBuilder sb = new StringBuilder(String.format("=== Error [%s] occured === \nSTACKTRACE:\n", ex.getMessage().toUpperCase()));
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
}
