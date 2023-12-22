package homeWork23.ui;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    public final SelenideElement bookTitleInCart = $("td a[href*='/books/details/']");
    public final SelenideElement bookPriceInCart = $("tr.ng-star-inserted td:nth-child(3)");
    public final SelenideElement totalPriceInCart = $("tfoot.table tr th:nth-last-child(2)");
    public final SelenideElement bookQuantityInCart = $("div.div-quantity");
    private final SelenideElement checkoutBtn = $("button.mat-focus-indicator.mat-raised-button.mat-warn");

    @Step("Proceed to checkout")
    public AddressPage proceedToCheckout() {
        checkoutBtn.click();
        return new AddressPage();
    }
}

