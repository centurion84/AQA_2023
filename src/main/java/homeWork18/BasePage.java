package homeWork18;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

abstract class BasePage {
    public final WebDriver driver;
    public final WebDriverWait wait;
    public final JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        this.js = (JavascriptExecutor) driver;
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

    public void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void scrollToTop() {
        js.executeScript("window.scrollTo(0, 0)");
    }

    public void scrollToBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void closeCurrentTabAndSwitchBack() {
        driver.close();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }
}
