import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.Homepage;
import pages.LoginPage;
import utils.WebDriverUtils;

import static pageUrl.PageUrl.HOMEPAGE_URL;

public class PanelHeaderLinkTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverUtils.createWebDriver();
    }

    @BeforeMethod
    public void beforeMethod() {driver.get(HOMEPAGE_URL);
    }

    @Test
    public void panelHeader_SignInLink_NavigatesToLoginPage() {
        //given
        Homepage homepage = new Homepage(driver);

        //when
        LoginPage loginPage = homepage.openLoginPage();

        //then
        Assertions.assertThat(driver.getCurrentUrl()).contains(HOMEPAGE_URL + "customer/account/login/");
        Assertions.assertThat(loginPage.getPageTitle()).isEqualTo("Customer Login");
    }

    @Test
    public void panelHeader_CreateAccountLink_NavigatesToLoginPage() {
        //given
        Homepage homepage = new Homepage(driver);

        //when
        CreateAccountPage createAccountPage = homepage.openCreateAccountPage();

        //then
        Assertions.assertThat(driver.getCurrentUrl()).contains(HOMEPAGE_URL + "customer/account/create/");
        Assertions.assertThat(createAccountPage.getPageTitle()).isEqualTo("Create New Customer Account");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
