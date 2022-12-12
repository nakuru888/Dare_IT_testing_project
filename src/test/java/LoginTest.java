import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.CustomerLoginPage;
import pages.LandingPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://magento.softwaretestingboard.com/");

    }
    @Test
    public void  testSingIn () {
        LandingPage onLandingPage = new LandingPage(driver);
        onLandingPage.loginAsButton();


        }

    public void testLoginWithProperCredentials () {

        CustomerLoginPage onCustomerLoginPage = new CustomerLoginPage(driver);
        onCustomerLoginPage.customerLoginAs("ala.k@wp.pl", "Password!1");

    }
    public void  confirmationOfLogin () {
        LandingPage onLandingPage = new LandingPage(driver);
        Assert.assertEquals("Welcome, Ala Kowalska!", onLandingPage.getLoggedUsername());
    }

    @After
    public void tearDown () {
        driver.quit();
    }

}
