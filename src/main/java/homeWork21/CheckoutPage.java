package homeWork21;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {

    final String SUCCESS_PURCHASE = "Thank you for your order!";
    final SelenideElement firstNameElement = $("#first-name");
    final SelenideElement lastNameElement = $("#last-name");
    final SelenideElement zipCodeElement = $("#postal-code");
    final SelenideElement continueBtnElement = $("#continue");
    final SelenideElement finishBtnElement = $("#finish");
    final SelenideElement purchaseHeaderElement = $("h2.complete-header");

    public CheckoutPage completeCustomerInformation(String firstName, String lastName, String zipCode) {
        firstNameElement.setValue(firstName);
        lastNameElement.setValue(lastName);
        zipCodeElement.setValue(zipCode);
        continueBtnElement.click();
        return new CheckoutPage();
    }

    public void finishCheckout() {
        finishBtnElement.click();
        purchaseHeaderElement.shouldHave(text(SUCCESS_PURCHASE));
    }
}

