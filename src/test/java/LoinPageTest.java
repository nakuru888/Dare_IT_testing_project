import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ForgotYourPasswordPage;
import pages.LoginPage;

import java.time.Duration;

public class LoinPageTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
    }

    @Test
    public void loginPage_LeftPanel_HasTexDisplayedAndSignInButtonEnabled() {
        //given
        LoginPage loginPage = new LoginPage(driver);

        //then
        Assert.assertTrue(loginPage.isTextPageTitleDisplayed());
        Assert.assertTrue(loginPage.isTextRegisteredCustomerDisplayed());
        Assert.assertTrue(loginPage.isTextSingInInstructionDisplayed());
        Assert.assertTrue(loginPage.isTextEmailLabelDisplayed());
        Assert.assertTrue(loginPage.isTextPasswordLabelDisplayed());
        Assert.assertTrue(loginPage.isSignInButtonEnabled());
        Assert.assertTrue(loginPage.isTextForgotYourPasswordDisplayed());
    }

    @Test
    public void loginPage_LeftPanel_HasTextCorrectlyPresented() {
        //given
        LoginPage loginPage = new LoginPage(driver);

        //then
        Assertions.assertThat(loginPage.getPageTitle()).isEqualTo("Customer Login");
        Assertions.assertThat(loginPage.getRegisteredCustomerText()).isEqualTo("Registered Customers");
        Assertions.assertThat(loginPage.getSingInInstructionText()).isEqualTo("If you have an account, sign in with your email address.");
        Assertions.assertThat(loginPage.getEmailLabel()).isEqualTo("Email");
        Assertions.assertThat(loginPage.getPasswordLabel()).isEqualTo("Password");
        Assertions.assertThat(loginPage.getSignInButtonText()).isEqualTo("Sign In");
        Assertions.assertThat(loginPage.getForgotYourPassword()).isEqualTo("Forgot Your Password?");
    }

    @Test
    public void loginPage_ForgotYourPasswordLink_NavigatesToForgotYourPasswordPage() {
        //given
        LoginPage loginPage = new LoginPage(driver);

        //when
        ForgotYourPasswordPage forgotYourPasswordPage = loginPage.openForgotYourPasswordPage();

        //then
        Assertions.assertThat(driver.getCurrentUrl()).contains("https://magento.softwaretestingboard.com/customer/account/forgotpassword/");
        Assertions.assertThat(forgotYourPasswordPage.getPageTitle()).isEqualTo("Forgot Your Password?");
    }

    @Test
    public void loginPage_SingInButtonColor_verifiesIfCorrect() {
        //given
        LoginPage loginPage = new LoginPage(driver);

        //then
        Assertions.assertThat(loginPage.verifySignInButtonColor()).isEqualTo("#1979c3");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
