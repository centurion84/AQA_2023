package homeWork18;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LinkedinPage extends BasePage {
    protected static final String LINKEDIN_TITLE = "LinkedIn";

    public LinkedinPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getLinkedinTitleText() {
        return driver.getTitle();
    }
}
