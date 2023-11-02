package homeWork14;

import homeWork9.ReverseString;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ReverseStringTest extends TestBase {

    @Test(groups = "ReverseStringTests")
    public void testReverseString() {
        String input = "Hello";
        String result = ReverseString.reverseString(input);
        assertEquals(result, "olleH");
    }

    @Test(groups = "ReverseStringTests")
    public void testReverseEmptyString() {
        String input = "";
        String result = ReverseString.reverseString(input);
        assertEquals(result, "");
    }
}

