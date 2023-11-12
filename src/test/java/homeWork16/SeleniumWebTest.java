package homeWork16;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static homeWork16.Selectors.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SeleniumWebTest extends BaseTest {

    @Test
    public void addBoxTest() {
        driver.get(URL_SELENIUM_PAGE);
        driver.findElement(ADD_BUTTON).click();

        WebElement redBox = wait.until(ExpectedConditions.visibilityOfElementLocated(REDBOX));

        assertTrue(redBox.getCssValue("width").equals(REDBOX_SIZE) &&
                        redBox.getCssValue("height").equals(REDBOX_SIZE),
                "Wrong box size");
        assertEquals(redBox.getCssValue("background-color"), REDBOX_COLOR, "Wrong box color");
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
