package homeWork14;

import homeWork9.RemoveChars;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class RemoveCharsTest extends TestBase {

    @Test(groups = "RemoveCharsTests")
    public void testRemoveCharacters() {
        char[] charsToRemove = {'a', 'b'};
        String input = "abcde";
        String result = RemoveChars.removeCharacters(input, charsToRemove);
        assertEquals(result, "cde");
    }

    @Test(groups = "RemoveCharsTests")
    public void testRemoveCharactersEmptyInput() {
        char[] charsToRemove = {'a', 'b'};
        String input = "";
        String result = RemoveChars.removeCharacters(input, charsToRemove);
        assertEquals(result, "");
    }

    @Test(groups = "RemoveCharsTests")
    public void testRemoveCharactersNoCharsToRemove() {
        char[] charsToRemove = {};
        String input = "abcde";
        String result = RemoveChars.removeCharacters(input, charsToRemove);
        assertEquals(result, "abcde");
    }
}

