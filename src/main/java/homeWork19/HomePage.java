package homeWork19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    @FindBy(css = "a[href*='contact_us']")
    private WebElement contactUsLink;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ContactUsPage navigateToContactUs() {
        clickElement(contactUsLink);
        return new ContactUsPage(driver);
    }
}
