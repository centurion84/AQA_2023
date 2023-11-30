package homeWork20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class DownloadPage {

    public final WebDriver driver;
    public final WebDriverWait wait;
    @FindBy(linkText = "csv_file.csv")
    private WebElement downloadLink;

    public DownloadPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void clickElement(WebElement webElement) {
        wait.until(visibilityOf(webElement)).click();
    }

    public void downloadFile() {
        clickElement(downloadLink);
    }
}
