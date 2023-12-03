package homeWork21;

import homeWork21.utils.BaseUITest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CartPageTest extends BaseUITest {

    @Test
    public void completePurchaseTest() {
        MainPage mainPage = new MainPage();
        CartPage cartPage = new CartPage();

        String addedToCartProductName = openLoginPage()
                .performLogin("standard_user", "secret_sauce")
                .verifyMainLogo()
                .addHighestPricedItemToCart()
                .getAddedProductName();
        assertTrue(cartPage.isProductInCart(addedToCartProductName), "Product is incorrect or not in the cart!");

        mainPage.goToCart()
                .proceedToCheckout()
                .completeCustomerInformation("John", "Doe", "12345")
                .finishCheckout();
    }
}

