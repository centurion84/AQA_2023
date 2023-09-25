package homeWork7;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorTest {
    final Calculator calculator = new Calculator();

    // add
    @Test
    public void testAddIntegers() {
        int result = calculator.add(5, 3);
        System.out.println("Result for add ints: " + result);
    }

    @Test
    public void testAddIntToDouble() {
        double result = calculator.add(5, 3.6);
        System.out.println("Result for add int to double: " + result);
    }

    @Test
    public void testAddDoubleToInt() {
        double result = calculator.add(5.5, 3);
        System.out.println("Result for add double to int: " + result);
    }

    @Test
    public void testAddDoubles() {
        double result = calculator.add(5.0, 3.5);
        System.out.println("Result for add doubles: " + result);
    }

    // subtract
    @Test
    public void testSubtractIntegers() {
        int result = calculator.subtract(5, 3);
        System.out.println("Result for subtract ints: " + result);
    }

    @Test
    public void testSubtractIntFromDouble() {
        double result = calculator.subtract(5.7, 3);
        System.out.println("Result for subtract int from double: " + result);
    }

    @Test
    public void testSubtractDoubleFromInt() {
        double result = calculator.subtract(5, 3.1);
        System.out.println("Result for subtract double from int: " + result);
    }

    @Test
    public void testSubtractDoubles() {
        double result = calculator.subtract(5.0, 3.5);
        assertEquals(result, 1.5, 0.001);
        System.out.println("Result for subtract doubles: " + result);
    }


    // multiply
    @Test
    public void testMultiplyIntegers() {
        int result = calculator.multiply(5, 3);
        System.out.println("Result for multiply ints: " + result);
    }

    @Test
    public void testMultiplyIntOnDouble() {
        double result = calculator.multiply(6, 2.5);
        System.out.println("Result for multiply int on double: " + result);
    }

    @Test
    public void testMultiplyDoubleOnInt() {
        double result = calculator.multiply(6.4, 2);
        System.out.println("Result for multiply double on int: " + result);
    }

    @Test
    public void testMultiplyDoubles() {
        double result = calculator.multiply(5.0, 3.5);
        System.out.println("Result for multiply doubles: " + result);
    }

    // divide
    @Test
    public void testDivideIntegers() {
        int result = calculator.divide(6, 2);
        System.out.println("Result for divide ints: " + result);
    }

    @Test
    public void testDivideIntOnDouble() {
        double result = calculator.divide(6, 2.5);
        System.out.println("Result for divide int on double: " + result);
    }
    @Test
    public void testDivideDoubleOnInt() {
        double result = calculator.divide(6.4, 2);
        System.out.println("Result for divide double on int: " + result);
    }

    @Test
    public void testDivideDoubles() {
        double result = calculator.divide(6.0, 2.0);
        System.out.println("Result for divide doubles: " + result);
    }
}

