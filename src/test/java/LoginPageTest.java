import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.WebDriverUtils;

import static colors.ColorsHex.*;
import static page.url.PageUrl.*;

public class LoginPageTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverUtils.createWebDriver();
        driver.get(LOGIN_PAGE_URL);
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
        softAssertions.assertThat(loginPage.getSignInButtonBackgroundColorAsHex()).isEqualTo(BLUE_COLOR);
        softAssertions.assertThat(loginPage.getSignInButtonFontColorAsHex()).isEqualTo(WHITE_COLOR);
        softAssertions.assertThat(loginPage.isTextForgotYourPasswordDisplayed()).isTrue();
        softAssertions.assertThat(loginPage.getForgotYourPasswordLinkText()).isEqualTo("Forgot Your Password?");
        softAssertions.assertThat(loginPage.getForgotYourPasswordLinkTextColorAsHex()).isEqualTo(LIGHT_BLUE_COLOR);
        softAssertions.assertThat(loginPage.getForgotYourPasswordLink()).isEqualTo(FORGOT_PASSWORD_PAGE_URL);
        softAssertions.assertAll();
    }

    @Test
    public void loginPage_HeaderFooterNavigationDemoCustomer_AreSectionsCorrectlyDisplayed() {
        //given
        LoginPage loginPage = new LoginPage(driver);

        //when
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(loginPage.isPageHeaderDisplayed()).isTrue();
        softAssertions.assertThat(loginPage.isPageNavigationBarDisplayed()).isTrue();
        softAssertions.assertThat(loginPage.isPageFooterDisplayed()).isTrue();
        softAssertions.assertThat(loginPage.isNewCustomerContainerDisplayed()).isTrue();
        softAssertions.assertThat(loginPage.isTryDemoCustomerAccessSectionDisplayed()).isTrue();
        softAssertions.assertAll();
    }

    @Test
    public void loginPage_NewCustomerSection_HasTitleAndTextAndButtonCorrectlyDisplayed() {
        //given
        LoginPage loginPage = new LoginPage(driver);

        //when
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(loginPage.isNewCustomersTitleDisplayed()).isTrue();
        softAssertions.assertThat(loginPage.getNewCustomersTitleText()).isEqualTo("New Customers");
        softAssertions.assertThat(loginPage.isNewCustomersMainTextDisplayed()).isTrue();
        softAssertions.assertThat(loginPage.getNewCustomersMainText()).
                isEqualTo("Creating an account has many benefits: check out faster, keep more than one address, track orders and more.");
        softAssertions.assertThat(loginPage.isCreateAccountButtonEnabled()).isTrue();
        softAssertions.assertThat(loginPage.getCreateAccountButtonText()).isEqualTo("Create an Account");
        softAssertions.assertThat(loginPage.getCreateAccountButtonLink()).isEqualTo(CREATE_AN_ACCOUNT_URL);
        softAssertions.assertThat(loginPage.getCreateAccountButtonFontColorAsHex()).isEqualTo(WHITE_COLOR);
        softAssertions.assertThat(loginPage.getCreateAccountButtonBackgroundColorAsHex()).isEqualTo(BLUE_COLOR);
        softAssertions.assertAll();
    }

    @Test
    public void loginPage_DemoCustomerCredentialSection_HasTitleAndTextAndEmailAndPasswordCorrectlyDisplayed() {
        //given
        LoginPage loginPage = new LoginPage(driver);

        //when
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(loginPage.isTryDemoCustomerAccessTitleDisplayed()).isTrue();
        softAssertions.assertThat(loginPage.getTryDemoCustomerAccessTitleText()).isEqualTo("Try Demo Customer Access");
        softAssertions.assertThat(loginPage.isTryDemoCustomerAccessEmailDisplayed()).isTrue();
        softAssertions.assertThat(loginPage.getTryDemoCustomerAccessEmailText()).isEqualTo("Email:roni_cost@example.com");
        softAssertions.assertThat(loginPage.isTryDemoCustomerAccessPasswordDisplayed()).isTrue();
        softAssertions.assertThat(loginPage.getTryDemoCustomerAccessPasswordText()).isEqualTo("Password:roni_cost3@example.com");
        softAssertions.assertThat(loginPage.getTryDemoCustomerAccessSectionBackgroundColorAsHex()).isEqualTo(LIGHT_PINK_COLOR);
        softAssertions.assertThat(loginPage.getTryDemoCustomerAccessSectionFontColorAsHex()).isEqualTo(BROWN_COLOR);
        softAssertions.assertAll();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
