package homeWork4;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        // saved password
        String correctPassword = "secret123";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input password:");

        while (true) {
            String userInput = scanner.nextLine();

            if (userInput.equals(correctPassword)) {
                System.out.println("Password has matched. Access granted)");
                break; // right password, closing execution
            } else {
                System.out.println("Incorrect password, try again:(");
            }
        }
    }
}
