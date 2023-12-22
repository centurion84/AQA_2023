package homeWork23.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import homeWork23.ui.HomePage;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeMethod;

import java.io.File;

import static com.codeborne.selenide.Selenide.open;

public class BaseUITest {

    public final String DOWNLOAD_FOLDER_PATH = "target/downloads";

    @BeforeMethod
    public void setup() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = "chrome";
        Configuration.reportsFolder = new File(DOWNLOAD_FOLDER_PATH).getAbsolutePath();
        Configuration.savePageSource = false;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://bookcart.azurewebsites.net/";
    }

    public HomePage opeHomePage() {
        open("");
        return new HomePage();
    }
}
