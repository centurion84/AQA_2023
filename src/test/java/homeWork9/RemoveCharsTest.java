package homeWork9;

import org.testng.annotations.Test;

public class RemoveCharsTest extends RemoveChars {

    @Test
    public void removeCharsTest() {
        String initialString = "abcd4efabc123deabcdaaa";
        char[] charactersToRemove = {'a', 'd', '3', '1', 'c'};

        String modifiedString = removeCharacters(initialString, charactersToRemove);

        System.out.println("Initial string: " + initialString);
        System.out.print("Characters to remove: ");
        for (char c : charactersToRemove) {
            System.out.print(c + " ");
        }
        System.out.println("\nModified string: " + modifiedString);
    }
}
