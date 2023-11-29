package homeWork19;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PropsAndFilesTest extends BaseUITest {

    @Test
    public void testContactUsForm() {
        ContactUsPage contactUsPage = new HomePage(driver)
                .navigateToContactUs()
                .fillNameAndEmail(props.getProperty("name"), props.getProperty("email"))
                .uploadFile(props.getProperty("file"))
                .submitContactForm();

        assertTrue(contactUsPage.isSuccessMessageShown());
    }
}
