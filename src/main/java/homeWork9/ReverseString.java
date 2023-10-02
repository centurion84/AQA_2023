package homeWork9;

public class ReverseString {
    public static String reverseString(String str) {
        // check if string is empty or contain one char
        if (str.isEmpty() || str.length() == 1) {
            return str;
        } else {
            char firstChar = str.charAt(0);
            String restOfString = str.substring(1);
            String reversedRest = reverseString(restOfString);
            return reversedRest + firstChar;
        }
    }
}
