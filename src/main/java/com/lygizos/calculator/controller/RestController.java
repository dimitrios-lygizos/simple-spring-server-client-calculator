package com.lygizos.calculator.controller;

import com.lygizos.calculator.model.CalculationsService;
import com.lygizos.calculator.model.RequestContentDto;
import com.lygizos.calculator.model.ResponseContentDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:61112") // For SWAGGER OAD try
public class RestController
{
    public RestController() {
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public ResponseContentDto add(
            @Valid @RequestBody RequestContentDto request
    ) {
        return new ResponseContentDto(CalculationsService.doAdd(request.x(), request.y()));
    }

    @PostMapping("/multiply")
    @ResponseStatus(HttpStatus.OK)
    public ResponseContentDto multiply(
            @Valid @RequestBody RequestContentDto request
    ) {
        return new ResponseContentDto(CalculationsService.doMulti(request.x(), request.y()));
    }

    @PostMapping("/divide")
    @ResponseStatus(HttpStatus.OK)
    public ResponseContentDto div(
            @Valid @RequestBody RequestContentDto request
    ) {
        return new ResponseContentDto(CalculationsService.doDivide(request.x(), request.y()));
    }

    @PostMapping("/subtract")
    @ResponseStatus(HttpStatus.OK)
    public ResponseContentDto subtract(
            @Valid @RequestBody RequestContentDto request
    ) {
        return new ResponseContentDto(CalculationsService.doSubtract(request.x(), request.y()));
    }

    @PostMapping("/modulo")
    @ResponseStatus(HttpStatus.OK)
    public ResponseContentDto modulo(
            @Valid @RequestBody RequestContentDto request
    ) {
        return new ResponseContentDto(CalculationsService.doModulo(request.x(), request.y()));

    }


}
