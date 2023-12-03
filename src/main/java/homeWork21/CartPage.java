package homeWork21;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

    final SelenideElement checkoutElement = $("#checkout");
    final ElementsCollection productNamesInCart = $$(".inventory_item_name");


    public boolean isProductInCart(String productName) {
        for (SelenideElement item : productNamesInCart) {
            if (item.text().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public CheckoutPage proceedToCheckout() {
        checkoutElement.click();
        return new CheckoutPage();
    }
}


