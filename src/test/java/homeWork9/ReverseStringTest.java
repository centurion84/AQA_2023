package homeWork9;

import org.testng.annotations.Test;

public class ReverseStringTest extends ReverseString{

    @Test
    public void reverseStringTest() {
        String original = "Java, World!";
        String reversed = reverseString(original);
        System.out.println("Original string: " + original);
        System.out.println("Reversed string: " + reversed);
    }
}
