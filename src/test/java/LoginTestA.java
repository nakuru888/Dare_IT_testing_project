import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pagesA.HomepageA;
import pagesA.LoginpageA;

import java.time.Duration;

public class LoginTestA {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magento.softwaretestingboard.com/");
    }
    @Test
    public void loginPage_LoginWithValidCredentials_Success(){
        //given
        LoginpageA loginpageA = new HomepageA(driver).openLoginPage();
        //nie rozumiem tej linijki - ta metoda jest w klasie HomepageA

        //when
        HomepageA homepageA = loginpageA.loginWithEmailAndPassword("ala.k@wp.pl", "Password!1");
        //ta metoda jest na loginpageA
        //haslo i login random ("test123addadaas@test123.com", "Test!234");

        //then
        Assertions.assertThat(homepageA.getWelcomeText()).isEqualTo("Welcome, Ala Kowalska!");

        //("Welcome, dfsfsdfs sdfsdfs!");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
