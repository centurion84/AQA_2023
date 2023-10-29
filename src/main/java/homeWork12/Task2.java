package homeWork12;

import java.util.HashSet;
import java.util.Set;

public class Task2 {
    public static void main(String[] args) {
        // create first hashSet and add elements
        Set<Object> set1 = new HashSet<>();
        set1.add(1);
        set1.add("green");
        set1.add(33.334);

        // create second hashSet and add elements
        Set<Object> set2 = new HashSet<>();
        set2.add(true);
        set2.add(4);
        set2.add("listElement");

        // create third hashSet and add elements of 1st and 2nd
        Set<Object> set3 = new HashSet<>(set1);
        set3.addAll(set2);

        // result output
        System.out.println("First HashSet: " + set1);
        System.out.println("Second HashSet: " + set2);
        System.out.println("Third HashSet (1st + 2nd): " + set3);
    }
}

