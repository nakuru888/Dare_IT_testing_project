import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;


import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class NewCustomerInfoOnLoginPageTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magento.softwaretestingboard.com/customer/account/login");
    }

//    @BeforeMethod
//    public void beforeMethod() {
//        driver.get("https://magento.softwaretestingboard.com/");
//    }

    @Test
    public void loginPage_VerifyingIfCorrectTextIsDisplayedForNewCustomer() {

        //given
        LoginPage loginpage = new LoginPage(driver);

        //then
        assertThat(loginpage.getTopMessageAboutNewCustomer()).isEqualTo("New Customers");
        assertThat(loginpage.getMainMessageAboutNewCustomer()).isEqualTo("Creating an account has many benefits: check out faster, keep more than one address, track orders and more.");
        assertThat(loginpage.getButtonMessageAboutNewCustomer()).isEqualTo("Create an Account");

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
