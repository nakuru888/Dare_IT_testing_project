import org.assertj.core.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.LoginPage;
import utils.WaitUtils;
import utils.WebDriverUtils;

import java.time.Duration;

public class LoginFormTest {

    private static final String INCORRECT_CAPTCHA_ERROR_MESSAGE = "Incorrect CAPTCHA";
    private static final String ERROR_MESSAGE_REQUIRED_FIELD = "This is a required field.";
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver= WebDriverUtils.createWebDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginPage_LoginWithValidCredentials_Success() {
        //when
        Homepage homepage = loginPage.loginWithEmailAndPassword("ala.k@wp.pl", "Password!1");

        //then
        validateWelcomeTextOrSkipWhenAskedForCaptcha(homepage);
    }

    @Test
    public void loginPage_LoginWithInvalidCredentials_FailureWithCorrectErrorMessageDisplayed() {
        //when
        loginPage.tryToLoginWithEmailAndPassword("bela.k@wp.pl", "XXX123");

        //then
        Assertions.assertThat(loginPage.getErrorMessageBannerText()).isIn(INCORRECT_CAPTCHA_ERROR_MESSAGE,
                "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
    }

    @Test
    public void loginPage_LoginWithEmptyEmailAndEmptyPassword_FailureWithCorrectErrorMessageDisplayed() {
        //given
        String emptyEmailOrPassword = "";

        //when
        loginPage.tryToLoginWithEmailAndPassword(emptyEmailOrPassword, emptyEmailOrPassword);

        //then
        validateLoginFormInputsErrorMessages(ERROR_MESSAGE_REQUIRED_FIELD, ERROR_MESSAGE_REQUIRED_FIELD);
    }

    @Test
    public void loginPage_LoginWithIncorrectEmailFormat_FailureWithCorrectErrorMessageDisplayed() {
        //when
        loginPage.tryToLoginWithEmailAndPassword("test123", "password1");

        //then
        validateLoginFormInputsErrorMessages("Please enter a valid email address (Ex: johndoe@domain.com).",
                null);
    }

    private void validateWelcomeTextOrSkipWhenAskedForCaptcha(Homepage homepage) {
        if (loginPage.getLoginFormInputsSize() == 2) {
            Assertions.assertThat(homepage.getWelcomeText()).isEqualTo("Welcome, Ala Kowalska!");
        }
    }

    public void validateLoginFormInputsErrorMessages(String expectedEmailInputErrorMessage, String expectedPasswordInputErrorMessage) {
        try {
            if (expectedEmailInputErrorMessage != null) {
                Assertions.assertThat(loginPage.getEmailInputErrorMessage()).isEqualTo(expectedEmailInputErrorMessage);
            }
            if (expectedPasswordInputErrorMessage != null) {
                Assertions.assertThat(loginPage.getPasswordInputErrorMessage()).isEqualTo(expectedPasswordInputErrorMessage);
            }
        } catch (NoSuchElementException e) {
            Assertions.assertThat(loginPage.isErrorMessageBannerDisplayed()).isTrue();
            Assertions.assertThat(loginPage.getErrorMessageBannerText()).isIn(INCORRECT_CAPTCHA_ERROR_MESSAGE,
                    "Invalid Form Key. Please refresh the page.", "A login and a password are required.");
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


