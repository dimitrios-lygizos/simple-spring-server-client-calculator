package com.lygizos.calculator;

import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final CalculationsService calculationService;

    public RestController(CalculationsService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping("/add")
    public String add() {
        return "";
    }

    @PostMapping("/multiply")
    public String multiply() {
        return "";

    }

    @PostMapping("/divide")
    public String div() {

        return "";
    }

    @PostMapping("/subtract")
    public String subtract() {

        return "";
    }
}
