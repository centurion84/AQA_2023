package homeWork12;

import java.util.HashMap;
import java.util.Map;

record Cow(String name) {
}

public class Task3 {
    public static void main(String[] args) {
        // create collection
        Map<String, Cow> cowMap = new HashMap<>();

        // add 10 cows to collection
        for (int i = 1; i <= 10; i++) {
            Cow cow = new Cow("Cow " + i);
            cowMap.put(cow.name(), cow);
        }

        // elements output
        for (Map.Entry<String, Cow> entry : cowMap.entrySet()) {
            System.out.println("Name: " + entry.getValue().name() + ", Cow object: " + entry.getKey());
        }
    }
}

