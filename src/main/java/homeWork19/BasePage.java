package homeWork19;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

abstract class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickBtn(WebElement webElement) {
        wait.until(elementToBeClickable(webElement)).click();
    }

    public void clickElement(WebElement webElement) {
        wait.until(visibilityOf(webElement)).click();
    }

    public void setText(WebElement webElement, String text) {
        wait.until(visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void acceptAlert() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
