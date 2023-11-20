package homeWork18;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.testng.Assert.assertNotNull;

public class MainPage extends BasePage {

    private String addedToCartProductName;
    @FindBy(css = ".app_logo")
    private WebElement swagLabsLogo;
    @FindBy(className = "social_linkedin")
    private WebElement linkedinLink;
    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuBtn;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;
    @FindBy(className = "inventory_item")
    private WebElement products;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> prices;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productNames;

    @FindBy(css = ".btn_inventory")
    private List<WebElement> addToCartButtons;

    @FindBy(className = "shopping_cart_link")
    private WebElement cart;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage verifyMainLogo() {
        assertNotNull(wait.until(visibilityOf(swagLabsLogo)), "Not logged in!");
        return this;
    }

    public LinkedinPage clickLinkedinLogo() {
        scrollToBottom();
        clickElement(linkedinLink);
        switchToNewTab();
        return new LinkedinPage(driver);
    }

    public CartPage clickCart() {
        clickElement(cart);
        return new CartPage(driver);
    }

    public MainPage addHighestPricedItemToCart() {
        List<Double> priceValues = prices.stream()
                .map(price -> Double.parseDouble(price.getText().substring(1)))
                .toList();

        double highestPrice = priceValues.stream().max(Double::compare).get();
        int highestPriceIndex = priceValues.indexOf(highestPrice);

        clickBtn(addToCartButtons.get(highestPriceIndex));
        addedToCartProductName = productNames.get(highestPriceIndex).getText();
        return this;
    }

    public String getAddedProductName() {
        return addedToCartProductName;
    }

    public void performLogout() {
        scrollToTop();
        clickElement(menuBtn);
        clickElement(logoutLink);
    }
}
