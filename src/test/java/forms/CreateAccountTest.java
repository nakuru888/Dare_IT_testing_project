package forms;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.UserPanel;
import utils.WebDriverUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static page.url.PageUrl.CREATE_AN_ACCOUNT_URL;
import static utils.TestUtils.randomString;

public class CreateAccountTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = WebDriverUtils.createWebDriver();
        driver.get(CREATE_AN_ACCOUNT_URL);
    }

    @Test
    public void createAccountForm_AllValidDataUsed_NewAccountCreatedAndUserLoggedInToUserPanel() {
        //given
        String firstname = randomString(5);
        String lastname = randomString(10);
        String email = lastname + "@test12.com";

        //when
        UserPanel userpanel = new CreateAccountPage(driver).fillInCreateAccountForm(firstname, lastname, email, "sdfsd@##4sD");

        //then
        assertThat(userpanel.getPageTitle()).isEqualTo("My Account");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
