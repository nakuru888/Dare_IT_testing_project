package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class LoginPage {
    private final By emailInputBy = By.id("email");
    private final By passwordInputBy = By.id("pass");
    private final By signInButton = By.id("send2");
    private final By pageTitle = By.className("page-title");
    private final By registeredCustomerText = By.cssSelector(".page-wrapper [id=block-customer-login-heading]");
    private final By singInInstructionText = By.cssSelector(".fieldset.login .field.note");
    private final By emailLabel = By.cssSelector(".field.email.required .label[for='email'] ");
    private final By passwordLabel = By.cssSelector(".page-wrapper .field.password.required .label");
    private final By forgotYourPassword = By.cssSelector(".secondary .action.remind");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public Homepage loginWithEmailAndPassword(String email, String password) {
        fillInInputField(driver.findElement(emailInputBy), email);
        fillInInputField(driver.findElement(passwordInputBy), password);
        driver.findElement(signInButton).click();
        return new Homepage(driver);
    }

    private void fillInInputField(WebElement element, String inputData) {
        element.click();
        element.clear();
        element.sendKeys(inputData);
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public boolean isTextPageTitleDisplayed() {
        if (driver.findElement(pageTitle).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public String getRegisteredCustomerText() {
        return driver.findElement(registeredCustomerText).getText();
    }

    public boolean isTextRegisteredCustomerDisplayed() {
        if (driver.findElement(registeredCustomerText).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public String getSingInInstructionText() {
        return driver.findElement(singInInstructionText).getText();
    }

    public boolean isTextSingInInstructionDisplayed() {
        if (driver.findElement(singInInstructionText).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public String getEmailLabel() {
        return driver.findElement(emailLabel).getText();
    }

    public boolean isTextEmailLabelDisplayed() {
        if (driver.findElement(emailLabel).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public String getPasswordLabel() {
        return driver.findElement(passwordLabel).getText();
    }

    public boolean isTextPasswordLabelDisplayed() {
        if (driver.findElement(passwordLabel).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public String getSignInButtonText() {
        return driver.findElement(signInButton).getText();
    }

    public boolean isSignInButtonEnabled() {
        if (driver.findElement(signInButton).isEnabled()) {
            return true;
        } else {
            return false;
        }
    }

    public String getForgotYourPassword() {
        return driver.findElement(forgotYourPassword).getText();
    }

    public boolean isTextForgotYourPasswordDisplayed() {
        if (driver.findElement(forgotYourPassword).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public String verifySignInButtonColor() {
        WebElement SignInButton = driver.findElement(signInButton);
        String ButtonColorRgba = SignInButton.getCssValue("background-color");
        String SiginInButtonColorHex = Color.fromString(ButtonColorRgba).asHex();
        return SiginInButtonColorHex;
    }

    public ForgotYourPasswordPage openForgotYourPasswordPage() {
        driver.findElement(forgotYourPassword).click();
        return new ForgotYourPasswordPage(driver);
    }
}

