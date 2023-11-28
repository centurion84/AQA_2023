package homeWork19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class ContactUsPage extends BasePage {
    private final TestProperties props = new TestProperties();
    private final String name = props.getProperty("name");
    private final String email = props.getProperty("email");
    private final String absolutePath = new File(props.getProperty("file")).getAbsolutePath();
    @FindBy(css = "input[data-qa='name']")
    private WebElement nameField;

    @FindBy(css = "input[data-qa='email']")
    private WebElement emailField;

    @FindBy(css = "input[name='upload_file']")
    private WebElement uploadFileBtn;

    @FindBy(css = "input[data-qa='submit-button']")
    private WebElement submitButton;

    @FindBy(css = "div[class='status alert alert-success']")
    private WebElement successMessage;

    public ContactUsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ContactUsPage fillNameAndEmail() {
        setText(nameField, name);
        setText(emailField, email);
        return this;
    }

    public ContactUsPage uploadFile() {
        setText(uploadFileBtn, absolutePath);
        return this;
    }

    public ContactUsPage submitContactForm() {
        clickBtn(submitButton);
        acceptAlert();
        return this;
    }

    public boolean isSuccessMessageShown() {
        String successMessageText = "Success! Your details have been submitted successfully";
        return successMessage.getText().contains(successMessageText);
    }
}
