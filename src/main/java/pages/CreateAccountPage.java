package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
    @FindBy(id = "firstname")
    private WebElement firstNameInput;

    @FindBy(id = "lastname")
    private WebElement lastNameInput;

    @FindBy(id = "email_address")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "password-confirmation")
    private WebElement confirmPasswordInput;

    @FindBy(className = "submit")
    private WebElement createAccountButton;

    @FindBy(className = "page-title")
    private WebElement pageTitle;

    private final WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public UserPanel fillInCreateAccountForm(String firstname, String lastname, String email, String password) {
        fillInInputField(firstNameInput, firstname);
        fillInInputField(lastNameInput, lastname);
        fillInInputField(emailInput, email);
        fillInInputField(passwordInput, password);
        fillInInputField(confirmPasswordInput, password);
        createAccountButton.click();
        return new UserPanel(driver);
    }

    private void fillInInputField(WebElement element, String dataToEnter) {
        element.click();
        element.clear();
        element.sendKeys(dataToEnter);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

}

