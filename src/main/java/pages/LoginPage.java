package pages;

import enums.Attribute;
import enums.CssProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.ColorUtils.getColorAsHex;
import static utils.WaitUtils.waitUntilElementsIsPresented;

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

    private final By pageHeader = By.className("page-header");
    private final By pageNavigationBar = By.className("navigation");
    private final By pageFooter = By.cssSelector(".page-footer");
    private final By newCustomerContainer = By.cssSelector(".page-wrapper .block.block-new-customer");
    private final By newCustomersTitle = By.cssSelector(".page-wrapper  #block-new-customer-heading");
    private final By newCustomersMainText = By.cssSelector(".page-wrapper .block-content > p");
    private final By createAccountButton = By.cssSelector(".login-container .block-new-customer .actions-toolbar a.action.primary");
    private final By tryDemoCustomerAccessSection = By.cssSelector(".widget.block.block-static-block .message.info");
    private final By tryDemoCustomerAccessTitle = By.cssSelector(".page-wrapper .message.info strong");
    private final By tryDemoCustomerAccessEmail = By.cssSelector(".page-wrapper .message.info p:nth-child(2)");
    private final By tryDemoCustomerAccessPassword = By.cssSelector(".page-wrapper .message.info p:nth-child(3)");
    private final By errorMessageBelowEmail = By.id("email-error");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public Homepage loginWithEmailAndPassword(String email, String password) {
        tryToLoginWithEmailAndPassword(email, password);
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

    public boolean isLoginFormContainerDisplayed() {
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

    public String getForgotYourPasswordLink() {
        return driver.findElement(forgotYourPasswordLink).getAttribute(Attribute.HREF.name().toLowerCase());
    }

    public boolean isTextForgotYourPasswordDisplayed() {
        return driver.findElement(forgotYourPasswordLink).isDisplayed();
    }

    public String getForgotYourPasswordLinkTextColorAsHex() {
        return getColorAsHex(driver, forgotYourPasswordLink, CssProperty.COLOR);
    }

    public String getSignInButtonBackgroundColorAsHex() {
        return getColorAsHex(driver, signInButton, CssProperty.BACKGROUND_COLOR);
    }

    public String getSignInButtonFontColorAsHex() {
        return getColorAsHex(driver, signInButton, CssProperty.COLOR);
    }

    public boolean isPageHeaderDisplayed() {
        return driver.findElement(pageHeader).isDisplayed();
    }

    public boolean isPageNavigationBarDisplayed() {
        return driver.findElement(pageNavigationBar).isDisplayed();
    }

    public boolean isPageFooterDisplayed() {
        return driver.findElement(pageFooter).isDisplayed();
    }

    public boolean isNewCustomerContainerDisplayed() {
        return driver.findElement(newCustomerContainer).isDisplayed();
    }

    public boolean isTryDemoCustomerAccessSectionDisplayed() {
        return driver.findElement(tryDemoCustomerAccessSection).isDisplayed();
    }

    public boolean isNewCustomersTitleDisplayed() {
        return driver.findElement(newCustomersTitle).isDisplayed();
    }

    public String getNewCustomersTitleText() {
        return driver.findElement(newCustomersTitle).getText();
    }

    public boolean isNewCustomersMainTextDisplayed() {
        return driver.findElement(newCustomersMainText).isDisplayed();
    }

    public String getNewCustomersMainText() {
        return driver.findElement(newCustomersMainText).getText();
    }

    public boolean isCreateAccountButtonEnabled() {
        return driver.findElement(createAccountButton).isDisplayed();
    }

    public String getCreateAccountButtonText() {
        return driver.findElement(createAccountButton).getText();
    }

    public String getCreateAccountButtonLink() {
        return driver.findElement(createAccountButton).getAttribute(Attribute.HREF.name().toLowerCase());
    }

    public boolean isTryDemoCustomerAccessTitleDisplayed() {
        return driver.findElement(tryDemoCustomerAccessTitle).isDisplayed();
    }

    public String getTryDemoCustomerAccessTitleText() {
        return driver.findElement(tryDemoCustomerAccessTitle).getText();
    }

    public boolean isTryDemoCustomerAccessEmailDisplayed() {
        return driver.findElement(tryDemoCustomerAccessEmail).isDisplayed();
    }

    public String getTryDemoCustomerAccessEmailText() {
        return driver.findElement(tryDemoCustomerAccessEmail).getText();
    }

    public boolean isTryDemoCustomerAccessPasswordDisplayed() {
        return driver.findElement(tryDemoCustomerAccessPassword).isDisplayed();
    }

    public String getTryDemoCustomerAccessPasswordText() {
        return driver.findElement(tryDemoCustomerAccessPassword).getText();
    }

    public String getCreateAccountButtonFontColorAsHex() {
        return getColorAsHex(driver, createAccountButton, CssProperty.COLOR);
    }

    public String getCreateAccountButtonBackgroundColorAsHex() {
        waitUntilElementsIsPresented(driver, createAccountButton, 5);
        return getColorAsHex(driver, createAccountButton, CssProperty.BACKGROUND_COLOR);
    }

    public String getTryDemoCustomerAccessSectionBackgroundColorAsHex() {
        return getColorAsHex(driver, tryDemoCustomerAccessSection, CssProperty.BACKGROUND_COLOR);
    }

    public String getTryDemoCustomerAccessSectionFontColorAsHex() {
        return getColorAsHex(driver, tryDemoCustomerAccessSection, CssProperty.COLOR);
    }

    public LoginPage tryToLoginWithEmailAndPassword(String email, String password) {
        fillInInputField(driver.findElement(emailInputBy), email);
        fillInInputField(driver.findElement(passwordInputBy), password);
        driver.findElement(signInButton).click();
        return this;
    }

    public String getErrorMessageIncorrectSignInWithCorrectEmailFormat() {
        return driver.findElement(By.cssSelector(".message-error.error.message")).getText();
    }

    public String getErrorMessageWithIncorrectEmailFormat() {
        return driver.findElement(By.id("email-error")).getText();
    }

    public String getErrorMessageEmptyPasswordField() {
        return driver.findElement(By.id("pass-error")).getText();
    }

    public String getErrorMessageEmptyEmailField() {
        return driver.findElement(By.id("email-error")).getText();
    }
}

