package homeWork23.ui;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private final SelenideElement checkoutBtn = $("button.mat-focus-indicator.mat-raised-button.mat-warn");
    private final SelenideElement bookTitleInCart = $("td a[href*='/books/details/']");
    private final SelenideElement bookPriceInCart = $("tr.ng-star-inserted td:nth-child(3)");
    private final SelenideElement totalPriceInCart = $("tfoot.table tr th:nth-last-child(2)");
    private final SelenideElement bookQuantityInCart = $("div.div-quantity");

    public boolean areBookDetailsInCartCorrect(String bookTitle, String bookPrice) {
        String title = bookTitleInCart.getText();
        String price = bookPriceInCart.getText();
        String totalPrice = totalPriceInCart.getText();
        String quantity = bookQuantityInCart.getText();
        return title.equals(bookTitle) &&
                price.equals(bookPrice) &&
                totalPrice.equals(bookPrice) &&
                quantity.equals("1");
    }

    public AddressPage proceedToCheckout() {
        checkoutBtn.click();
        return new AddressPage();
    }
}

