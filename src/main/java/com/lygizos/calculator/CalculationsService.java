package com.lygizos.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculationsService {

    // Addition
    public Double doAdd(double x, double y) {
        return x+y;
    }

    // Multiplication
    public Double doMulti(double x, double y) {
        return x*y;
    }

    // Division
    public Double doDivide(double x, double y) {
        if (y==0.0)
            throw new ArithmeticException("Division by zero! -.-");

        return x/y;
    }

    // Subtraction
    public Double doSubtract(double x, double y) {
        return x-y;
    }

    // modulo division
    public Double doModulo(double x, double y) {
        if (y==0.0)
            throw new ArithmeticException("Division by zero! -.-");

        return x%y;
    }

}
