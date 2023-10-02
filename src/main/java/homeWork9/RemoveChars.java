package homeWork9;

public class RemoveChars {
    public static String removeCharacters(String input, char[] charactersToRemove) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (indexOfCharacter(charactersToRemove, currentChar) == -1) {
                result.append(currentChar);
            }
        }

        return result.toString();
    }

    public static int indexOfCharacter(char[] arr, char target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
