package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class LoginPage {
    private final By emailInputBy = By.id("email");
    private final By passwordInputBy = By.cssSelector(".page-wrapper #pass");
    private final By signInButton = By.cssSelector(".page-wrapper #send2");
    private final By pageTitle = By.className("page-title");
    private final By registeredCustomerText = By.cssSelector(".page-wrapper #block-customer-login-heading");
    private final By singInInstructionText = By.cssSelector(".fieldset.login .field.note");
    private final By loginFormContainer = By.cssSelector(".login-container .block-customer-login #login-form");
    private final By emailLabel = By.cssSelector(".page-wrapper .field.email.required .label");
    private final By passwordLabel = By.cssSelector(".page-wrapper .field.password.required .label");
    private final By forgotYourPasswordLinkText = By.cssSelector(".secondary .action.remind");

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
        return driver.findElement(pageTitle).isDisplayed();
    }

    public String getRegisteredCustomerText() {
        return driver.findElement(registeredCustomerText).getText();
    }

    public boolean isTextRegisteredCustomerDisplayed() {
        return driver.findElement(registeredCustomerText).isDisplayed();
    }

    public String getSingInInstructionText() {
        return driver.findElement(singInInstructionText).getText();
    }

    public boolean isTextSingInInstructionDisplayed() {
        return driver.findElement(singInInstructionText).isDisplayed();
    }

    public boolean isLoginFormContainer(){
        return driver.findElement(loginFormContainer).isDisplayed();
    }

    public String getEmailLabel() {
        return driver.findElement(emailLabel).getText();
    }

    public boolean isTextEmailLabelDisplayed() {
        return driver.findElement(emailLabel).isDisplayed();
    }

    public String getPasswordLabel() {
        return driver.findElement(passwordLabel).getText();
    }

    public boolean isTextPasswordLabelDisplayed() {
        return driver.findElement(passwordLabel).isDisplayed();
    }

    public String getSignInButtonText() {
        return driver.findElement(signInButton).getText();
    }

    public boolean isSignInButtonEnabled() {
        return driver.findElement(signInButton).isEnabled();
    }

    public String getForgotYourPasswordLinkText() {
        return driver.findElement(forgotYourPasswordLinkText).getText();
    }

    public boolean isTextForgotYourPasswordDisplayed() {
        return driver.findElement(forgotYourPasswordLinkText).isDisplayed();
    }

    public String getForgotYourPasswordLinkTextColorAsHex() {
        WebElement signInButtonColor = driver.findElement(forgotYourPasswordLinkText);
        String forgotYourPasswordTextLinkRgba = signInButtonColor.getCssValue("color");
        return Color.fromString(forgotYourPasswordTextLinkRgba).asHex();
    }

    public String getSignInButtonBackgroundColorAsHex() {
        WebElement signInButtonColor = driver.findElement(signInButton);
        String buttonColorBackgroundRgba = signInButtonColor.getCssValue("background-color");
        return Color.fromString(buttonColorBackgroundRgba).asHex();
    }

    public String getSignInButtonFontColorAsHex() {
        WebElement signInButtonColor = driver.findElement(signInButton);
        String buttonColorFontRgba = signInButtonColor.getCssValue("color");
        return Color.fromString(buttonColorFontRgba).asHex();
    }
}

