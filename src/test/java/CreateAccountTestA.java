import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pagesA.CreateAccountPageA;
import pagesA.UserPanel;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static utilsA.TestUtilsA.randomString;

public class CreateAccountTestA {

    private WebDriver driver;

    @BeforeClass
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
    }

    @Test
    public void createAccountForm_AllValidDataUsed_NewAccountCreatedAndUserLoggedInToUserPanel() {
        //given
        String firstname = randomString(5);
        String lastname = randomString(10);
        String email = lastname + "@test12.com";

        //when
        UserPanel userpanel = new CreateAccountPageA(driver).fillInCreateAccountForm(firstname,lastname,email,"sdfsd@##4sD");

        //to hasło jest na sztywno?


        //then
        assertThat(userpanel.getPageTitle()).isEqualTo("My Account");

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
