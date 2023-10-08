package homeWork3;

import java.util.Scanner;

// solve quadratic equation
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a, b, c;

        String invalidInput = "Invalid input. Please enter a valid double value";

        while (true) {

            System.out.print("Input coefficient a: ");
            if (scanner.hasNextDouble()) {
                a = scanner.nextDouble();
                break;
            } else {
                System.out.println(invalidInput + " for 'a'");
                scanner.next();
            }
        }

        while (true) {
            System.out.print("Input coefficient b: ");
            if (scanner.hasNextDouble()) {
                b = scanner.nextDouble();
                break;
            } else {
                System.out.println(invalidInput + " for 'a'");
                scanner.next();
            }
        }

        while (true) {
            System.out.print("Input coefficient c: ");
            if (scanner.hasNextDouble()) {
                c = scanner.nextDouble();
                break;
            } else {
                System.out.println(invalidInput + " for 'a'");
                scanner.next();
            }
        }

        double discriminant = Math.pow(b, 2) - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.pow(discriminant, 0.5)) / (2 * a);
            double root2 = (-b - Math.pow(discriminant, 0.5)) / (2 * a);
            System.out.println("The equation has two roots:");
            System.out.println("Root 1: " + root1);
            System.out.println("Root 2: " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("The equation has one root:" + root);
        } else {
            System.out.println("The equation has no roots!");
        }

        scanner.close();
    }
}