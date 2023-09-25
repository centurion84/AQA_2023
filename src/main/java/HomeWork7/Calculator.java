package homeWork7;

public class Calculator {

    // adding
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double add(int a, double b) {
        return a + b;
    }

    public double add(double a, int b) {
        return a + b;
    }

    // subtraction
    public int subtract(int a, int b) {
        return a - b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double subtract(int a, double b) {
        return a - b;
    }

    public double subtract(double a, int b) {
        return a - b;
    }

    // multiplying
    public int multiply(int a, int b) {
        return a * b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double multiply(int a, double b) {
        return a * b;
    }

    public double multiply(double a, int b) {
        return a * b;
    }

    // division
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is impossible");
        }
        return a / b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is impossible");
        }
        return a / b;
    }

    public double divide(int a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is impossible");
        }
        return a / b;
    }

    public double divide(double a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is impossible");
        }
        return a / b;
    }
}

