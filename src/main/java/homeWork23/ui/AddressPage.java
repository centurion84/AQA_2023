package homeWork23.ui;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AddressPage {

    public final SelenideElement bookTitleInOrder = $("td a[href*='/books/details/']");
    public final SelenideElement bookPriceInOrder = $("tr.ng-star-inserted td:nth-child(4)");
    public final SelenideElement totalPriceInOrder = $("tr.ng-star-inserted td:nth-child(4)");
    public final SelenideElement bookQuantityInOrder = $("table.table tr.ng-star-inserted td:nth-child(2)");
    private final SelenideElement nameInput = $("input[formcontrolname='name']");
    private final SelenideElement address1Input = $("input[formcontrolname='addressLine1']");
    private final SelenideElement address2Input = $("input[formcontrolname='addressLine2']");
    private final SelenideElement pinCodeInput = $("input[formcontrolname='pincode']");
    private final SelenideElement stateInput = $("input[formcontrolname='state']");
    private final SelenideElement placeOrderBtn = $("button[type='submit']");
    private final SelenideElement checkOutSnackBar = $("simple-snack-bar");
    private final SelenideElement checkOutSnackBarText = $("simple-snack-bar span");
    private final String CHECKOUT_TEXT = "Order placed successfully!!!";

    public boolean isCheckOutSnackBarShown() {
        try {
            checkOutSnackBar.shouldBe(visible);
            checkOutSnackBarText.shouldHave(text(CHECKOUT_TEXT));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Fill address data for order")
    public AddressPage fillAddressDetails(String name, String address1, String address2, String pinCode, String state) {
        nameInput.setValue(name);
        address1Input.setValue(address1);
        address2Input.setValue(address2);
        pinCodeInput.setValue(pinCode);
        stateInput.setValue(state);
        return this;
    }

    @Step("Make an order")
    public OrdersPage placeOrder() {
        placeOrderBtn.click();
        return new OrdersPage();
    }
}
