package homeWork23.ui;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement userNameInput = $("input[data-placeholder='Username']");
    private final SelenideElement userPasswordInput = $("input[data-placeholder='Password']");
    private final SelenideElement loginBtn = $("button.mat-raised-button.mat-primary");
    private final SelenideElement shownUserName = $x("//span[@class='mat-button-wrapper' and count(mat-icon[@role='img'])=2]");

    @Step("Login by user")
    public HomePage performLogin(String userName, String userPassword) {
        userNameInput.setValue(userName);
        userPasswordInput.setValue(userPassword);
        loginBtn.click();
        shownUserName.shouldHave(text(userName));
        return new HomePage();
    }
}
