package com.lygizos.calculator;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final CalculationsService calculationService;

    public RestController(CalculationsService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping("/add")
    public ResponseContentDto add(
            @RequestBody RequestContentDto request
    ) {
        return new ResponseContentDto(calculationService.doAdd(request.x(), request.y()));
    }

    @PostMapping("/multiply")
    public ResponseContentDto multiply(
            @RequestBody RequestContentDto request
    ) {
        return new ResponseContentDto(calculationService.doMulti(request.x(), request.y()));
    }

    @PostMapping("/divide")
    public ResponseContentDto div(
            @RequestBody RequestContentDto request
    ) {
        return new ResponseContentDto(calculationService.doDivide(request.x(), request.y()));
    }

    @PostMapping("/subtract")
    public ResponseContentDto subtract(
            @RequestBody RequestContentDto request
    ) {
        return new ResponseContentDto(calculationService.doSubtract(request.x(), request.y()));
    }

    @PostMapping("/modulo")
    public ResponseContentDto modulo(
            @RequestBody RequestContentDto request
    ) {
        return new ResponseContentDto(calculationService.doModulo(request.x(), request.y()));
    }
}
