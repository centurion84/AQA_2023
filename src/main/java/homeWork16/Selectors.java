package homeWork16;

import org.openqa.selenium.By;

public class Selectors {

    public static final String URL_HIDDEN = "https://the-internet.herokuapp.com/dynamic_loading/1";
    public static final String URL_RENDERED_AFTER = "https://the-internet.herokuapp.com/dynamic_loading/2";
    public static final String URL_SELENIUM_PAGE = "https://www.selenium.dev/selenium/web/dynamic.html";

    public static final By START_BUTTON = By.xpath("//div[@id='start']/button");
    public static final By HELLO_WORLD_TEXT = By.id("finish");
    public static final By ADD_BUTTON = By.id("adder");
    public static final By REVEAL_BUTTON = By.id("reveal");

    public static final By REDBOX = By.id("box0");
    public static final By REVEALED = By.id("revealed");
    public static final String EXPECTED_TEXT = "Hello World!";
    public static final String TEST_TEXT_INPUT = "Test text";
    public static final String REDBOX_SIZE = "150px";
    public static final String REDBOX_COLOR = "rgba(255, 0, 0, 1)";
}
