package homeWork14;

import homeWork9.PhoneNumber;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class PhoneNumberTest extends TestBase {

    @Test(dataProvider = "validPhoneNumbers", groups = "PhoneNumberTests")
    public void testValidPhoneNumber(String phoneNumber) {
        assertTrue(PhoneNumber.validatePhoneNumber(phoneNumber));
    }

    @Test(dataProvider = "invalidPhoneNumbers", groups = "PhoneNumberTests")
    public void testInvalidPhoneNumber(String phoneNumber) {
        assertFalse(PhoneNumber.validatePhoneNumber(phoneNumber));
    }

    @DataProvider(name = "validPhoneNumbers")
    public Object[][] validPhoneNumbers() {
        return new Object[][]{
                {"+38(095)1234567"},
                {"+38(044)123-45-67"}
        };
    }

    @DataProvider(name = "invalidPhoneNumbers")
    public Object[][] invalidPhoneNumbers() {
        return new Object[][]{
                {"+380951234567"},
                {"+38(095)1234"},
                {"+38(095)12345A"}
        };
    }
}

