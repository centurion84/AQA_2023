package homeWork21;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    final ElementsCollection prices = $$(".inventory_item_price");
    final ElementsCollection names = $$(".inventory_item_name");
    final SelenideElement cartBtnElement = $(".shopping_cart_link");
    final SelenideElement swagLabsLogoElement = $(".app_logo");
    final ElementsCollection inventoryBtnElements = $$(".btn_inventory");
    private String addedToCartProductName;

    public MainPage addHighestPricedItemToCart() {
        double highestPrice = 0.0;
        int highestPriceIndex = 0;

        for (int i = 0; i < prices.size(); i++) {
            double price = Double.parseDouble(prices.get(i).text().substring(1));
            if (price > highestPrice) {
                highestPrice = price;
                highestPriceIndex = i;
            }
        }

        inventoryBtnElements.get(highestPriceIndex).click();
        addedToCartProductName = names.get(highestPriceIndex).getText();
        return this;
    }

    public MainPage verifyMainLogo() {
        swagLabsLogoElement.shouldBe(visible);
        return this;
    }

    public String getAddedProductName() {
        return addedToCartProductName;
    }

    public CartPage goToCart() {
        cartBtnElement.click();
        return new CartPage();
    }
}


