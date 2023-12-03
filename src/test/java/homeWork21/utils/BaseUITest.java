package homeWork21.utils;

import com.codeborne.selenide.Configuration;
import homeWork21.LoginPage;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class BaseUITest {

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.saucedemo.com/";
    }

    public LoginPage openLoginPage() {
        open("");
        return new LoginPage();
    }
}

