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
    private final By registeredCustomerSectionTitle = By.cssSelector(".page-wrapper #block-customer-login-heading");
    private final By singInInstruction = By.cssSelector(".fieldset.login .field.note");
    private final By loginFormContainer = By.cssSelector(".login-container .block-customer-login #login-form");
    private final By emailLabel = By.cssSelector(".page-wrapper .field.email.required .label");
    private final By passwordLabel = By.cssSelector(".page-wrapper .field.password.required .label");
    private final By forgotYourPasswordLink = By.cssSelector(".secondary .action.remind");

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
        return driver.findElement(registeredCustomerSectionTitle).getText();
    }

    public boolean isTextRegisteredCustomerDisplayed() {
        return driver.findElement(registeredCustomerSectionTitle).isDisplayed();
    }

    public String getSingInInstructionText() {
        return driver.findElement(singInInstruction).getText();
    }

    public boolean isTextSingInInstructionDisplayed() {
        return driver.findElement(singInInstruction).isDisplayed();
    }

    public boolean isLoginFormContainerDisplayed(){
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
        return driver.findElement(forgotYourPasswordLink).getText();
    }

    public boolean isTextForgotYourPasswordDisplayed() {
        return driver.findElement(forgotYourPasswordLink).isDisplayed();
    }

    public String getForgotYourPasswordLinkTextColorAsHex() {
        WebElement forgotYourPasswordLinkElement = driver.findElement(forgotYourPasswordLink);
        String forgotYourPasswordTextLinkRgba = forgotYourPasswordLinkElement.getCssValue("color");
        return Color.fromString(forgotYourPasswordTextLinkRgba).asHex();
    }

    public String getSignInButtonBackgroundColorAsHex() {
        WebElement signInButtonElement = driver.findElement(signInButton);
        String buttonColorBackgroundRgba = signInButtonElement.getCssValue("background-color");
        return Color.fromString(buttonColorBackgroundRgba).asHex();
    }

    public String getSignInButtonFontColorAsHex() {
        WebElement signInButtonElement = driver.findElement(signInButton);
        String buttonColorFontRgba = signInButtonElement.getCssValue("color");
        return Color.fromString(buttonColorFontRgba).asHex();
    }
}

