package com.lygizos.calculator.model;

import org.springframework.stereotype.Service;

@Service
public class CalculationsService {

    // Addition
    public static Double doAdd(double x, double y) {
        return x+y;
    }

    // Multiplication
    public static Double doMulti(double x, double y) { return x*y; }

    // Division
    public static Double doDivide(double x, double y) {  return x/y; }

    // Subtraction
    public static Double doSubtract(double x, double y) { return x-y; }

    // modulo division
    public static Double doModulo(double x, double y) { return x%y; }

}
