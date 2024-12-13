package com.lygizos.calculator;

import com.lygizos.calculator.model.CalculationsService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Random;

public class CalculationsServiceTests {
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

        double result = CalculationsService.doAdd(x,y);
        assertEquals(x+y, result);
    }

    @Test
    public void testAdditionPositiveAndNegativeDigits() {
        double x = -5.4;
        double y = 6;

        double result = CalculationsService.doAdd(x, y);
        assertEquals(x + y, result);
    }

    @Test
    public void testAdditionZeroAndZeroDigits() {
        double x = 0;
        double y = -0;

        double result = CalculationsService.doAdd(x,y);
        assertEquals(x+y, result);
    }

    @Test
    public void testAdditionRandomDigits() {
        double x = random.nextDouble();
        double y = random.nextDouble();

        double result = CalculationsService.doAdd(x,y);
        assertEquals(x+y, result);
    }

    /**
     * MULTIPLICATION TEST SECTION
     */
    @Test
    public void testMultiplicationPositiveDigits() {
        double x = 10.5;
        double y = 3.9;

        double result = CalculationsService.doMulti(x,y);
        assertEquals(x*y, result);
    }

    @Test
    public void testMultiplicationNegativeDigits() {
        double x = -19;
        double y = -2;

        double result = CalculationsService.doMulti(x,y);
        assertEquals(x*y, result);
    }

    @Test
    public void testMultiplicationPositiveAndNegativeDigits() {
        double x = 9.8;
        double y = -20;

        double result = CalculationsService.doMulti(x,y);
        assertEquals(x*y, result);
    }

    @Test
    public void testMultiplicationPositiveAndZeroDigits() {
        double x = 0;
        double y = 3.9;

        double result = CalculationsService.doMulti(x,y);
        assertEquals(x*y, result);
    }

    @Test
    public void testMultiplicationNegativeAndZeroDigits() {
        double x = -10.5;
        double y = 0;

        double result = CalculationsService.doMulti(x,y);
        assertEquals(x*y, result);
    }

    @Test
    public void testMultiplicationZeroAndZeroDigits() {
        double x = 0;
        double y = 0;

        double result = CalculationsService.doMulti(x,y);
        assertEquals(x*y, result);
    }

    @Test
    public void testMultiplicationRandomDigits() {
        double x = random.nextDouble();
        double y = random.nextDouble();

        double result = CalculationsService.doMulti(x,y);
        assertEquals(x*y, result);
    }

    /**
     * NUMBER DIVISION TEST SECTION
     */
    @Test
    public void testDivisionPositiveDigits() {
        double x = 10.5;
        double y = 3.9;

        double result = CalculationsService.doDivide(x, y);
        assertEquals(x / y, result);
    }

    @Test
    public void testDivisionNegativeDigits() {
        double x = -19;
        double y = -2;

        double result = CalculationsService.doDivide(x, y);
        assertEquals(x / y, result);
    }

    @Test
    public void testDivisionPositiveAndNegativeDigits() {
        double x = 9.8;
        double y = -20;

        double result = CalculationsService.doDivide(x,y);
        assertEquals(x/y, result);
    }

    @Test
    public void testDivisionZeroAndNegativeDigits() {
        double x = 0;
        double y = 3.9;

        double result = CalculationsService.doDivide(x,y);
        assertEquals(x/y, result);
    }

    @Test
    public void testDivisionNegativeAndZeroDigits() {
        double x = 0;
        double y = -10.5;

        double result = CalculationsService.doDivide(x,y);
        assertEquals(x/y, result);
    }

    @Test
    public void test_Division_Throws_Exception_When_Nominator_is_Zero() {
        double x = -999.999;
        double y = 0;

        Double result = CalculationsService.doDivide(x,y);
        assertTrue(result.isInfinite());
    }

    @Test
    public void testDivisionRandomDigits() {
        double x = random.nextDouble();
        double y = random.nextDouble(1,Double.MAX_VALUE);

        double result = CalculationsService.doDivide(x,y);
        assertEquals(x/y, result);
    }

    /**
     * NUMBER SUBTRACTION TEST SECTION
     */
    @Test
    public void testSubPositiveDigits() {
        double x = 53.678;
        double y = 32.9;

        double result = CalculationsService.doSubtract(x,y);
        assertEquals(x-y, result);
    }

    @Test
    public void testSubNegativeDigits() {
        double x = -19.0194;
        double y = -29.2;

        double result = CalculationsService.doSubtract(x,y);
        assertEquals(x-y, result);
    }

    @Test
    public void testSubPositiveAndNegativeDigits() {
        double x = 109.7;
        double y = -20;

        double result = CalculationsService.doSubtract(x,y);
        assertEquals(x-y,result);
    }

    @Test
    public void testSubPositiveAndZeroDigits() {
        double x = 0;
        double y = 3.9;

        double result = CalculationsService.doSubtract(x,y);
        assertEquals(x-y, result);
    }

    @Test
    public void testSubNegativeAndZeroDigits() {
        double x = -10.5;
        double y = 0;

        double result = CalculationsService.doSubtract(x,y);
        assertEquals(x-y, result);
    }

    @Test
    public void testSubZeroAndZeroDigits() {
        double x = 0;
        double y = 0;

        double result = CalculationsService.doSubtract(x,y);
        assertEquals(x-y, result);
    }

    @Test
    public void testSubRandomDigits() {
        double x = random.nextDouble();
        double y = random.nextDouble();

        double result = CalculationsService.doSubtract(x,y);
        assertEquals(x-y, result);
    }

    /**
     * Modulo TEST SECTION
     */
    @Test
    public void testModuloPositiveDigits() {
        double x = 53.678;
        double y = 32.9;

        double result = CalculationsService.doModulo(x,y);
        assertEquals(x%y,result);
    }

    @Test
    public void testModuloNegativeDigits() {
        double x = -19.0194;
        double y = -29.2;
        double result = CalculationsService.doModulo(x,y);
        assertEquals(x%y, result);
    }

    @Test
    public void testModuloPositiveAndNegativeDigits() {
        double x = 109.7;
        double y = -20;

        double result = CalculationsService.doModulo(x,y);
        assertEquals(x%y, result);
    }

    @Test
    public void testModuloPositiveAndZeroDigits() {
        double x = 0;
        double y = 3.9;

        double result = CalculationsService.doModulo(x,y);
        assertEquals(x%y, result);
    }

    @Test
    public void testModuloNegativeAndZeroDigits() {
        double x = 0;
        double y = -10.5;

        double result = CalculationsService.doModulo(x,y);
        assertEquals(x%y, result);
    }

    @Test
    public void test_Modulo_Throws_Exception_When_Nominator_is_Zero() {
        double x = 3;
        double y = 0;

        Double result = CalculationsService.doModulo(x,y);
        assertTrue(result.isNaN());
    }

    @Test
    public void testModuloRandomDigits() {
        double x = random.nextDouble();
        double y = random.nextDouble();

        double result = CalculationsService.doModulo(x,y);
        assertEquals(x%y, result);
    }
}
