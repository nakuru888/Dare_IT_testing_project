import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.LoginPage;


import java.time.Duration;

public class LoginTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magento.softwaretestingboard.com/");
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

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
