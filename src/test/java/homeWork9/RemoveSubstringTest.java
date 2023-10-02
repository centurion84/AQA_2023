package homeWork9;

import org.testng.annotations.Test;

public class RemoveSubstringTest extends  RemoveSubstring{

    @Test
    public void removeFromStringTest() {
        String mainString = "This is the test string";
        String removableString = "st";

        String newString = removeSubstring(mainString, removableString);

        System.out.println("The main string is: " + mainString);
        System.out.println("The removable string is: " + removableString);
        System.out.println("The new string is: " + newString);
    }
}
