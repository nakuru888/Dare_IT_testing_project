import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
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
        //given
        LoginPage loginpage = new Homepage(driver).openLoginPage();

        //when
        Homepage homepage = loginpage.loginWithEmailAndPassword("ala.k@wp.pl", "Password!1");

        //then
        Assertions.assertThat(homepage.getWelcomeText()).isEqualTo("Welcome, Ala Kowalska!");
    }

    @Test
    public void loginPage_LoginWithValidEmailAndInvalidPassword_FailureToLogInWithErrorMessageIncorrectSignInDisplayed(){
        //given
        String validEmail = "ala.k@wp.pl";
        String invalidPassword = "XXXXX";

        //when
        LoginPage loginPage = new LoginPage(driver).loginWithInvalidEmailAndPassword(validEmail, invalidPassword);

        //then
        Assertions.assertThat(driver.findElement(By.cssSelector(".message-error.error.message")).getText()).
                isEqualTo("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
    }
    @Test
    public void loginPage_LoginWithInvalidEmailAndInvalidPassword_FailureToLogInWithErrorMessageIncorrectSignInDisplayed(){
        //given
        String invalidEmail = "test@test.pl";
        String invalidPassword = "XXXXX";

        //when
        LoginPage loginPage = new LoginPage(driver).loginWithInvalidEmailAndPassword(invalidEmail, invalidPassword);

        //then
        Assertions.assertThat(driver.findElement(By.cssSelector(".message-error.error.message")).getText()).
                isEqualTo("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
    }

    @Test
    public void loginPage_LoginWithInvalidEmailAndEmptyPassword_FailureToLogInWithErrorMessageThisIsRequiredFieldDisplayed(){
        //given
        String invalidEmail = "test@test.pl";
        String emptyPassword = "";

        //when
        LoginPage loginPage = new LoginPage(driver).loginWithInvalidEmailAndPassword(invalidEmail, emptyPassword);

        //then
        Assertions.assertThat(driver.findElement(By.id("pass-error")).getText()).isEqualTo("This is a required field.");
    }

    @Test
    public void loginPage_LoginWithValidEmailAndEmptyPassword_FailureToLogInWithErrorMessageThisIsRequiredFieldDisplayed(){
        //given
        String validEmail = "ala.k@wp.pl";
        String emptyPassword = "";

        //when
        LoginPage loginPage = new LoginPage(driver).loginWithInvalidEmailAndPassword(validEmail, emptyPassword);

        //then
        Assertions.assertThat(driver.findElement(By.id("pass-error")).getText()).isEqualTo("This is a required field.");
    }

    @Test
    public void loginPage_LoginWithEmptyEmailAndEmptyPassword_FailureToLogInWithErrorMessageThisIsRequiredFieldDisplayed(){
        //given
        String emptyEmail = "";
        String emptyPassword = "";

        //when
        LoginPage loginPage = new LoginPage(driver).loginWithInvalidEmailAndPassword(emptyEmail, emptyPassword);

        //then
        Assertions.assertThat(driver.findElement(By.id("email-error")).getText()).isEqualTo("This is a required field.");
        Assertions.assertThat(driver.findElement(By.id("pass-error")).getText()).isEqualTo("This is a required field.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
