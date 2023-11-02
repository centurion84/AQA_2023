package homeWork14;

import homeWork9.RemoveSubstring;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class RemoveSubstringTest extends TestBase {

    @Test(groups = "RemoveSubstringTests")
    public void testRemoveSubstring() {
        String mainString = "Hello, World!";
        String removableString = ", ";
        String result = RemoveSubstring.removeSubstring(mainString, removableString);
        assertEquals(result, "HelloWorld!");
    }

    @Test(groups = "RemoveSubstringTests")
    public void testRemoveSubstringNonExistentSubstring() {
        String mainString = "Hello, World!";
        String removableString = "123";
        String result = RemoveSubstring.removeSubstring(mainString, removableString);
        assertEquals(result, mainString);
    }
}
