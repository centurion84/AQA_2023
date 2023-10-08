package homeWork4;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter double values (enter 0 to finish):");

        double userInput;
        double sum = 0.0; // Sum of entered values

        do {
            while (!scanner.hasNextDouble()) {
                System.out.println("Enter a valid double value:");
                scanner.next();
            }
            userInput = scanner.nextDouble();

            if (userInput != 0) {
                sum += userInput;
            }
        } while (userInput != 0);

        System.out.println("Sum of all entered values: " + sum);

        scanner.close();
    }
}
