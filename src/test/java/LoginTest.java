//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import pages.LoginPage;
//import pages.HomePage;
//
//import java.time.Duration;
//
//
//
//public class LoginTest {
//
//    private static WebDriver driver;
//
//    @BeforeClass
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.get("https://magento.softwaretestingboard.com/");
//
//    }
//
//    @Test
//    public void testSingIn() {
//        HomePage onLandingPage = new HomePage(driver);
//        onLandingPage.loginAsButton();
//    }
//    @Test
//    public void testLoginWithProperCredentials() {
//        LoginPage onCustomerLoginPage = new LoginPage(driver);
//        onCustomerLoginPage.loginWithEmailAndPassword("ala.k@wp.pl", "Password!1");
//    }
//    @Test
//    public void confirmationOfLogin() {
//        HomePage onLandingPage = new HomePage(driver);
//        Assert.assertEquals("Welcome, Ala Kowalska!", onLandingPage.getLoggedUsername());
//    }
//
////    @AfterClass
////    public void tearDown() {
////        driver.quit();
////    }
//
//}
