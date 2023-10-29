package homeWork12;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        // create ArrayList with integer objects
        List<Integer> numbers = new ArrayList<>();

        // fill list with data
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);

        // find even numbers only
        numbers.removeIf(number -> number % 2 != 0);

        // result output
        System.out.println("Filtered list (even numbers): " + numbers);
    }
}

