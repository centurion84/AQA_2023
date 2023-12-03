package homeWork21;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    final SelenideElement loginElement = $("#user-name");
    final SelenideElement passwordElement = $("#password");
    final SelenideElement submitBtnElement = $("#login-button");

    public MainPage performLogin(String login, String password) {
        loginElement.setValue(login);
        passwordElement.setValue(password);
        submitBtnElement.click();
        return new MainPage();
    }
}

