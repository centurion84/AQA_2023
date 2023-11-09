package homeWork15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductsInCart {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    protected final String pageTitlePath = "//a[@class='Navbar_logo__26S5Y']";
    protected final int firstItem = 1;
    protected final int secondItem = 2;
    protected final String pricePath = "//div[@id='%s']//div[@class='shelf-item__price']//div[@class='val']//b";
    protected final String titlePath = "//div[@id='%s']//p[@class='shelf-item__title']";
    protected final String addButtonPath = "//div[@id='%s']//div[@class='shelf-item__buy-btn']";

    protected final String itemFieldPath = "//div[@class='float-cart__shelf-container']//div[@class='shelf-item']";
    protected final String emptyCartViewPath = "//div[@class='float-cart__shelf-container']//p[@class='shelf-empty']";
    protected final String priceCartPath = itemFieldPath + "[%s]//div[@class='shelf-item__price']//p";
    protected final String titleCartPath = itemFieldPath + "[%s]//div[@class='shelf-item__details']//p[@class='title']";
    protected final String quantityCartPath = itemFieldPath + "[%s]//div[@class='shelf-item__details']//p[@class='desc']";
    protected final String cartViewPath = "//div[@class='float-cart float-cart--open']//div[@class='float-cart__content']";
    protected final String removeItemButtonPath = "//div[@class='float-cart__shelf-container']//div[@class='shelf-item__del']";
    protected final String totalCartPrice = "//p[@class='sub-price__val']";
    protected final String closeCartPath = "//div[@class='float-cart float-cart--open']//div[@class='float-cart__close-btn']";
    protected final String checkoutButtonPath = "//div[contains(@class,'buy-btn') and text()='Checkout']";
    protected final String totalPriceRegex = "\\$\\s*(\\d+)\\.\\d{2}";
    protected final String quantityCartRegex = "\\bQuantity: (\\d+)\\b";

    public static WebElement findElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public static List<WebElement> findElements(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    public static void findAndClick(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        element.click();
    }

    public static int extractNumber(String text, String patternString) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            try {
                return Integer.parseInt(matcher.group(1));
            } catch (NumberFormatException e) {
                return -1;
            }
        }
        return -1;
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("https://www.bstackdemo.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageTitlePath)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public WebElement findItemElement(String path, int itemNumber) {
        String xpathExpression = String.format(path, itemNumber);
        return driver.findElement(By.xpath(xpathExpression));
    }

    public void findAndClickItemElement(String path, int itemNumber) {
        String xpathExpression = String.format(path, itemNumber);
        WebElement element = driver.findElement(By.xpath(xpathExpression));
        element.click();
    }
}
