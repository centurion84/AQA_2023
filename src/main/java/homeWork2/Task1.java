package homeWork2;
import java.util.InputMismatchException;
import java.util.Scanner;

@SuppressWarnings("ManualMinMaxCalculation")
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number1 = 0.0;
        double number2 = 0.0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the first number: ");
                number1 = scanner.nextDouble();
                System.out.print("Enter the second number: ");
                number2 = scanner.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter an integer or a decimal number.");
                scanner.nextLine(); // clear buffer
            }
        }
        double maxNumber = (number1 > number2) ? number1 : number2;
        System.out.println("The larger number is: " + maxNumber);
    }
}