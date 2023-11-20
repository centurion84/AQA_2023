package homeWork18;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productNamesInCart;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isProductInCart(String productName) {
        for (WebElement item : productNamesInCart) {
            if (item.getText().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public CheckoutPage proceedToCheckout() {
        clickBtn(checkoutButton);
        return new CheckoutPage(driver);
    }
}
