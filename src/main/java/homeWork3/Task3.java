package homeWork3;

import java.util.Scanner;

// define whether a year is a leap one or not
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year;
        while (true) {
            System.out.print("Enter the calendar year number: ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer");
                scanner.next();
            }
        }
        // leap years start from 45 b.c., year number must be divisible by 4, 400, but not 100
        if (year > -45 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year");
        }

        scanner.close();
    }
}