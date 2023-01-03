import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginPageTest {
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
    public void loginPage_PageTitle_HasPageTitleCorrectlyDisplayed() {
        //given
        LoginPage loginPage = new LoginPage(driver);

        //then
        Assertions.assertThat(loginPage.isTextPageTitleDisplayed()).isTrue();
        Assertions.assertThat(loginPage.getPageTitle()).isEqualTo("Customer Login");
    }

    @Test
    public void loginPage_LoginFormSection_HasIntroductionAndLoginFormCorrectlyDisplayed() {
        //given
        LoginPage loginPage = new LoginPage(driver);

        //then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(loginPage.isTextRegisteredCustomerDisplayed()).isTrue();
        softAssertions.assertThat(loginPage.getRegisteredCustomerText()).isEqualTo("Registered Customers");
        softAssertions.assertThat(loginPage.isTextSingInInstructionDisplayed()).isTrue();
        softAssertions.assertThat(loginPage.getSingInInstructionText()).isEqualTo("If you have an account, sign in with your email address.");
        softAssertions.assertThat(loginPage.isLoginFormContainerDisplayed()).isTrue();
        softAssertions.assertThat(loginPage.isTextEmailLabelDisplayed()).isTrue();
        softAssertions.assertThat(loginPage.getEmailLabel()).isEqualTo("Email");
        softAssertions.assertThat(loginPage.isTextPasswordLabelDisplayed()).isTrue();
        softAssertions.assertThat(loginPage.getPasswordLabel()).isEqualTo("Password");
        softAssertions.assertThat(loginPage.isSignInButtonEnabled()).isTrue();
        softAssertions.assertThat(loginPage.getSignInButtonText()).isEqualTo("Sign In");
        softAssertions.assertThat(loginPage.getSignInButtonBackgroundColorAsHex()).isEqualTo("#1979c3");
        softAssertions.assertThat(loginPage.getSignInButtonFontColorAsHex()).isEqualTo("#ffffff");
        softAssertions.assertThat(loginPage.isTextForgotYourPasswordDisplayed()).isTrue();
        softAssertions.assertThat(loginPage.getForgotYourPasswordLinkText()).isEqualTo("Forgot Your Password?");
        softAssertions.assertThat(loginPage.getForgotYourPasswordLinkTextColorAsHex()).isEqualTo("#006bb4");
        softAssertions.assertThat(driver.findElement(By.cssSelector(".secondary .action.remind")).getAttribute("href")).
                isEqualTo("https://magento.softwaretestingboard.com/customer/account/forgotpassword/");
        softAssertions.assertAll();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
