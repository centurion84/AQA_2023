package homeWork9;

import org.testng.annotations.Test;

public class PhoneNumberTest extends PhoneNumber {

    @Test
    public void phoneNumberTest() {
        String phoneNumber = "+38(063)123-45-67";
        boolean isValid = validatePhoneNumber(phoneNumber);

        if (isValid) {
            System.out.println("Phone number is ok)");
        } else {
            System.out.println("Phone number is invalid!");
        }
    }
}
