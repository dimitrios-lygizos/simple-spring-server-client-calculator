package com.lygizos.calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Random;

public class CalculationsServiceTests {
    private final CalculationsService cs = new CalculationsService();
    private static Random random;

    @BeforeAll
    public static void setup() {
        random = new Random(LocalDate.now().toEpochDay());
    }

    /**
     * ADD TEST SECTION
     */
    @Test
    public void testAdditionPositiveDigits() {
        double x = 10.5;
        double y = 3.9;

        double result = cs.doAdd(x,y);
        assertEquals(result, x+y);
    }

    @Test
    public void testAdditionPositiveAndNegativeDigits() {
        double x = -5.4;
        double y = 6;

        double result = cs.doAdd(x, y);
        assertEquals(result, x + y);
    }

    @Test
    public void testAdditionZeroAndZeroDigits() {
        double x = 0;
        double y = -0;

        double result = cs.doAdd(x,y);
        assertEquals(result, x+y);
    }

    @Test
    public void testAdditionRandomDigits() {
        double x = random.nextDouble();
        double y = random.nextDouble();

        double result = cs.doAdd(x,y);
        assertEquals(result, x+y);
    }

    /**
     * MULTIPLICATION TEST SECTION
     */
    @Test
    public void testMultiplicationPositiveDigits() {
        double x = 10.5;
        double y = 3.9;

        double result = cs.doMulti(x,y);
        assertEquals(result, x*y);
    }

    @Test
    public void testMultiplicationNegativeDigits() {
        double x = -19;
        double y = -2;

        double result = cs.doMulti(x,y);
        assertEquals(result, x*y);
    }

    @Test
    public void testMultiplicationPositiveAndNegativeDigits() {
        double x = 9.8;
        double y = -20;

        double result = cs.doMulti(x,y);
        assertEquals(result, x*y);
    }

    @Test
    public void testMultiplicationPositiveAndZeroDigits() {
        double x = 0;
        double y = 3.9;

        double result = cs.doMulti(x,y);
        assertEquals(result, x*y);
    }

    @Test
    public void testMultiplicationNegativeAndZeroDigits() {
        double x = -10.5;
        double y = 0;

        double result = cs.doMulti(x,y);
        assertEquals(result, x*y);
    }

    @Test
    public void testMultiplicationZeroAndZeroDigits() {
        double x = 0;
        double y = 0;

        double result = cs.doMulti(x,y);
        assertEquals(result, x*y);
    }

    @Test
    public void testMultiplicationRandomDigits() {
        double x = random.nextDouble();
        double y = random.nextDouble();

        double result = cs.doMulti(x,y);
        assertEquals(result, x*y);
    }

    /**
     * NUMBER DIVISION TEST SECTION
     */
    @Test
    public void testDivisionPositiveDigits() {
        double x = 10.5;
        double y = 3.9;

        double result = cs.doDivide(x,y);
        assertEquals(result, x/y);
    }

    @Test
    public void testDivisionNegativeDigits() {
        double x = -19;
        double y = -2;

        double result = cs.doDivide(x,y);
        assertEquals(result, x/y);
    }

    @Test
    public void testDivisionPositiveAndNegativeDigits() {
        double x = 9.8;
        double y = -20;

        double result = cs.doDivide(x,y);
        assertEquals(result, x/y);
    }

    @Test
    public void testDivisionZeroAndNegativeDigits() {
        double x = 0;
        double y = 3.9;

        double result = cs.doDivide(x,y);
        assertEquals(result, x/y);
    }

    @Test
    public void testDivisionNegativeAndZeroDigits() {
        double x = 0;
        double y = -10.5;

        double result = cs.doDivide(x,y);
        assertEquals(result, x/y);
    }

    @Test
    public void test_Division_Throws_Exception_When_Nominator_is_Zero() {
        double x = -999.999;
        double y = 0;

        ArithmeticException ex = assertThrows(ArithmeticException.class, () -> cs.doDivide(x,y));
        assertEquals(ex.getMessage(), "Division by zero! -.-");
    }

    @Test
    public void testDivisionRandomDigits() {
        double x = random.nextDouble();
        double y = random.nextDouble(1,Double.MAX_VALUE);

        double result = cs.doDivide(x,y);
        assertEquals(result, x/y);
    }

    /**
     * NUMBER SUBTRACTION TEST SECTION
     */
    @Test
    public void testSubPositiveDigits() {
        double x = 53;
        double y = 32.9;

        double result = cs.doSubtract(x,y);
        assertEquals(result, x-y);
    }

    @Test
    public void testSubNegativeDigits() {
        double x = -19;
        double y = -29.2;

        double result = cs.doSubtract(x,y);
        assertEquals(result, x-y);
    }

    @Test
    public void testSubPositiveAndNegativeDigits() {
        double x = 109.7;
        double y = -20;

        double result = cs.doSubtract(x,y);
        assertEquals(result, x-y);
    }

    @Test
    public void testSubPositiveAndZeroDigits() {
        double x = 0;
        double y = 3.9;

        double result = cs.doSubtract(x,y);
        assertEquals(result, x-y);
    }

    @Test
    public void testSubNegativeAndZeroDigits() {
        double x = -10.5;
        double y = 0;

        double result = cs.doSubtract(x,y);
        assertEquals(result, x-y);
    }

    @Test
    public void testSubZeroAndZeroDigits() {
        double x = 0;
        double y = 0;

        double result = cs.doSubtract(x,y);
        assertEquals(result, x-y);
    }

    @Test
    public void testSubRandomDigits() {
        double x = random.nextDouble();
        double y = random.nextDouble();

        double result = cs.doSubtract(x,y);
        assertEquals(result, x-y);
    }
}
