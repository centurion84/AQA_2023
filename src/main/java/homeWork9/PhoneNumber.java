package homeWork9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    public static boolean validatePhoneNumber(String phoneNumber) {
        String regex = "\\+38\\(0\\d{2}\\)\\d{7}|\\+38\\(0\\d{2}\\)\\d{3}-\\d{2}-\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }
}
