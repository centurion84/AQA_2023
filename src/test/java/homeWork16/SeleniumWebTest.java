package homeWork16;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static homeWork16.Selectors.*;
import static org.testng.Assert.assertEquals;

public class SeleniumWebTest extends BaseTest {

    @Test
    public void AddBoxTest() {
        driver.get(URL_SELENIUM_PAGE);
        driver.findElement(ADD_BUTTON).click();

        WebElement redBox = wait.until(ExpectedConditions.visibilityOfElementLocated(REDBOX));

        assertEquals(redBox.getAttribute("style"), REDBOX_STYLE, "Redbox style does not match");
    }

    @Test
    public void RevealNewInputTest() {
        driver.get(URL_SELENIUM_PAGE);
        driver.findElement(REVEAL_BUTTON).click();

        WebElement revealedInput = wait.until(ExpectedConditions.visibilityOfElementLocated(REVEALED));
        revealedInput.clear();
        revealedInput.sendKeys(TEST_TEXT_INPUT);

        assertEquals(revealedInput.getAttribute("value"), TEST_TEXT_INPUT, "Input field did not contain the expected text");
    }

}
