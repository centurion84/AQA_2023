package homeWork16;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static homeWork16.Selectors.*;
import static org.testng.Assert.assertEquals;

public class HelloWorldTest extends BaseTest {
    @Test
    public void elementHiddenTest() {

        driver.get(URL_HIDDEN);
        driver.findElement(START_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(HELLO_WORLD_TEXT));

        assertEquals(driver.findElement(HELLO_WORLD_TEXT).getText(), EXPECTED_TEXT, "Text does not match");
    }

    @Test
    public void elementRenderedAfterTest() {

        driver.get(URL_RENDERED_AFTER);
        driver.findElement(START_BUTTON).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(HELLO_WORLD_TEXT));

        assertEquals(driver.findElement(HELLO_WORLD_TEXT).getText(), EXPECTED_TEXT, "Text does not match");
    }
}
