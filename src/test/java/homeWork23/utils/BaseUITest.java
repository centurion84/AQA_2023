package homeWork23.utils;

import com.codeborne.selenide.Configuration;
import homeWork23.ui.HomePage;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class BaseUITest {

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.screenshots = false;
        Configuration.savePageSource = false;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://bookcart.azurewebsites.net/";
    }

    public HomePage opeHomePage() {
        open("");
        return new HomePage();
    }
}
