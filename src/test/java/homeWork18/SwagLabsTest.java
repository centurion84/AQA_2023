package homeWork18;

import homeWork18.utils.BaseUITest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SwagLabsTest extends BaseUITest {

    @Test
    public void linkedinTest() {
        MainPage mainPage = new MainPage(driver);
        LinkedinPage linkedinPage = new LinkedinPage(driver);

        String linkedinTitle = openLoginPage()
                .completeLogin()
                .verifyMainLogo()
                .clickLinkedinLogo()
                .getLinkedinTitleText();
        assertTrue(linkedinTitle.contains(LinkedinPage.LINKEDIN_TITLE), "Opened tab is wrong!");

        linkedinPage.closeCurrentTabAndSwitchBack();
        mainPage.performLogout();
    }

    @Test
    public void cartTest() {
        MainPage mainPage = new MainPage(driver);
        CartPage cartPage = new CartPage(driver);

        String addedToCartProductName = openLoginPage()
                .completeLogin()
                .verifyMainLogo()
                .addHighestPricedItemToCart()
                .getAddedProductName();
        assertTrue(cartPage.isProductInCart(addedToCartProductName), "Product is incorrect or not in the cart!");

        String successPurchase = mainPage.clickCart().proceedToCheckout().completePurchase();
        assertTrue(successPurchase.contains(CheckoutPage.SUCCESS_PURCHASE), "Purchase was failed!");
    }
}
