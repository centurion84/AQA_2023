package homeWork2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter an integer: ");
                number = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter an integer!");
                scanner.nextLine(); // clear buffer
            }
        }
        String message = (number % 2 == 0) ? "The number is even" : "The number is odd";
        System.out.println(message);
    }
}
