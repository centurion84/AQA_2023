package homeWork18;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {

    private static final String FIRSTNAME = "Andrii";
    private static final String LASTNAME = "Prylepskyi";
    private static final String POSTAL_CODE = "65104";
    protected static final String SUCCESS_PURCHASE = "Thank you for your order!";
    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(className = "complete-header")
    private WebElement completeHeader;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String completePurchase() {
        setText(firstNameField, FIRSTNAME);
        setText(lastNameField, LASTNAME);
        setText(postalCodeField, POSTAL_CODE);
        clickBtn(continueButton);
        clickBtn(finishButton);
        return completeHeader.getText();
    }
}

