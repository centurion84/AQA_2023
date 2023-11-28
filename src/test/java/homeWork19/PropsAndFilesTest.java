package homeWork19;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PropsAndFilesTest extends BaseUITest {

    @Test
    public void testContactUsForm() {
        ContactUsPage contactUsPage = new HomePage(driver)
                .navigateToContactUs()
                .fillNameAndEmail()
                .uploadFile()
                .submitContactForm();

        assertTrue(contactUsPage.isSuccessMessageShown());
    }
}
