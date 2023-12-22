package homeWork23.ui;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private final SelenideElement loginBtn = $x("//button[contains(., 'Login')]");
    private final SelenideElement searchBox = $("input.mat-autocomplete-trigger[type='search']");
    private final SelenideElement confirmSearch = $("span.mat-option-text");
    private final SelenideElement bookTitleInList = $("div.card-title strong");
    private final SelenideElement bookPriceInList = $("div.card-title + p");
    private final SelenideElement addToCartBtn = $("span.mat-button-wrapper > span > mat-icon.material-icons");
    private final SelenideElement cartBtn = $("#mat-badge-content-0");
    private final SelenideElement cartSnackBar = $("simple-snack-bar");
    private final SelenideElement cartSnackBarText = $("simple-snack-bar span");
    private final String ADDED_TO_CART_TEXT = "One Item added to cart";

    public LoginPage goToLogin() {
        loginBtn.click();
        return new LoginPage();
    }

    @Step("Search book")
    public HomePage searchForBook(String bookName) {
        searchBox.setValue(bookName);
        confirmSearch.click();
        return this;
    }

    @Step("Add book to cart")
    public HomePage addBookToCart() {
        addToCartBtn.click();
        return this;
    }

    @Step("Go to cart")
    public CartPage goToCart() {
        WebElement element = cartBtn.toWebElement();
        executeJavaScript("arguments[0].click();", element);
        return new CartPage();
    }

    public boolean isCartSnackBarShown() {
        try {
            cartSnackBar.shouldBe(visible);
            cartSnackBarText.shouldHave(text(ADDED_TO_CART_TEXT));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getBookTitle() {
        return bookTitleInList.getText();
    }

    public String getBookPrice() {
        return bookPriceInList.getText();
    }
}

