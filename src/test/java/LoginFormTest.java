import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.LoginPage;


import java.time.Duration;

public class LoginFormTest {
    private WebDriver driver;

    private static final String ERROR_MESSAGE_INCORRECT_SIGN_IN = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
    private static final String ERROR_MESSAGE_INCORRECT_SIGN_IN_CAPTCHA = "Incorrect CAPTCHA";
    private static final String ERROR_MESSAGE_REQUIRED_FIELD = "This is a required field.";
    private static final String ERROR_MESSAGE_INCORRECT_EMAIL_FORMAT = "Please enter a valid email address (Ex: johndoe@domain.com).";
    private static final String VALID_EMAIL_SUCCESS_LOGIN = "ala.k@wp.pl";
    private static final String VALID_EMAIL_FAILURE_LOGIN = "bela.k@wp.pl";
    private static final String VALID_PASSWORD = "Password!1";
    private static final String INVALID_EMAIL = "xxx@test.pl";
    private static final String INVALID_PASSWORD = "XXX123";
    private static final String EMPTY_EMAIL = "";
    private static final String EMPTY_PASSWORD = "";
    private static final String INCORRECT_EMAIL_FORMAT = "test123";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
    }

    @Test
    public void loginPage_LoginWithValidCredentials_Success() {
        //when
        Homepage homepage = new LoginPage(driver).loginWithEmailAndPassword(VALID_EMAIL_SUCCESS_LOGIN, VALID_PASSWORD);

        //then
        Assertions.assertThat(homepage.getWelcomeText()).isEqualTo("Welcome, Ala Kowalska!");
    }

    @Test
    public void loginPage_LoginWithValidEmailAndInvalidPassword_FailureWithCorrectErrorMessageDisplayed() {
        //when
        LoginPage loginPage = new LoginPage(driver).tryToLoginWithEmailAndPassword(VALID_EMAIL_FAILURE_LOGIN, INVALID_PASSWORD);

        //then
        Assertions.assertThat(loginPage.getErrorMessageIncorrectSignInWithCorrectEmailFormat()).isEqualTo(ERROR_MESSAGE_INCORRECT_SIGN_IN_CAPTCHA);
    }

    @Test
    public void loginPage_LoginWithInvalidEmailAndInvalidPassword_FailureWithCorrectErrorMessageDisplayed() {
        //when
        LoginPage loginPage = new LoginPage(driver).tryToLoginWithEmailAndPassword(INVALID_EMAIL, INVALID_PASSWORD);

        //then
        Assertions.assertThat(loginPage.getErrorMessageIncorrectSignInWithCorrectEmailFormat()).isEqualTo(ERROR_MESSAGE_INCORRECT_SIGN_IN_CAPTCHA);
    }

    @Test
    public void loginPage_LoginWithInvalidEmailAndEmptyPassword_FailureWithCorrectErrorMessageDisplayed() {
        //when
        LoginPage loginPage = new LoginPage(driver).tryToLoginWithEmailAndPassword(INVALID_EMAIL, EMPTY_PASSWORD);

        //then
        Assertions.assertThat(loginPage.getErrorMessageEmptyPasswordField()).isEqualTo(ERROR_MESSAGE_REQUIRED_FIELD);
    }

    @Test
    public void loginPage_LoginWithValidEmailAndEmptyPassword_FailureWithCorrectErrorMessageDisplayed() {
        //when
        LoginPage loginPage = new LoginPage(driver).tryToLoginWithEmailAndPassword(VALID_EMAIL_FAILURE_LOGIN, EMPTY_PASSWORD);

        //then
        Assertions.assertThat(loginPage.getErrorMessageEmptyPasswordField()).isEqualTo(ERROR_MESSAGE_REQUIRED_FIELD);
    }

    @Test
    public void loginPage_LoginWithEmptyEmailAndEmptyPassword_FailureWithCorrectErrorMessageDisplayed() {
        //when
        LoginPage loginPage = new LoginPage(driver).tryToLoginWithEmailAndPassword(EMPTY_EMAIL, EMPTY_PASSWORD);

        //then
        Assertions.assertThat(loginPage.getErrorMessageEmptyEmailField()).isEqualTo(ERROR_MESSAGE_REQUIRED_FIELD);
        Assertions.assertThat(loginPage.getErrorMessageEmptyPasswordField()).isEqualTo(ERROR_MESSAGE_REQUIRED_FIELD);
    }

    @Test
    public void loginPage_LoginWithIncorrectEmailFormatAndEmptyPassword_FailureWithCorrectErrorMessageDisplayed() {
        //when
        LoginPage loginPage = new LoginPage(driver).tryToLoginWithEmailAndPassword(INCORRECT_EMAIL_FORMAT, EMPTY_PASSWORD);

        //then
        Assertions.assertThat(loginPage.getErrorMessageWithIncorrectEmailFormat()).isEqualTo(ERROR_MESSAGE_INCORRECT_EMAIL_FORMAT);
        Assertions.assertThat(loginPage.getErrorMessageEmptyPasswordField()).isEqualTo(ERROR_MESSAGE_REQUIRED_FIELD);
    }

    @Test
    public void loginPage_LoginWithIncorrectEmailFormatAndInvalidPassword_FailureWithCorrectErrorMessageDisplayed() {
        //when
        LoginPage loginPage = new LoginPage(driver).tryToLoginWithEmailAndPassword(INCORRECT_EMAIL_FORMAT, INVALID_PASSWORD);

        //then
        Assertions.assertThat(loginPage.getErrorMessageWithIncorrectEmailFormat()).isEqualTo(ERROR_MESSAGE_INCORRECT_EMAIL_FORMAT);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
