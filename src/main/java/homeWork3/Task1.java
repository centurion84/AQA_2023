package homeWork3;

import java.util.Scanner;

// define week day by int input
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dayNumber;
        while (true) {
            System.out.print("Enter a number: ");
            if (scanner.hasNextInt()) {
                dayNumber = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }

        String dayOfWeek = getDayOfWeek(dayNumber);
        System.out.println("Day of the week: " + dayOfWeek);

        scanner.close();
    }

    public static String getDayOfWeek(int dayNumber) {
        return switch (dayNumber) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Unknown. Number should be between 1 and 7.";
        };
    }
}
