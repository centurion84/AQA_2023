package homeWork18;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage setUserName() {
        setText(usernameField, USERNAME);
        return this;
    }

    public LoginPage setPassword() {
        setText(passwordField, PASSWORD);
        return this;
    }

    public MainPage submit() {
        clickBtn(loginButton);
        return new MainPage(driver);
    }

    public MainPage completeLogin() {
        setUserName();
        setPassword();
        submit();
        return new MainPage(driver);
    }
}
