import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Homepage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class MainBannerTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magento.softwaretestingboard.com");
    }

    @Test
    public void homepage_verifyingCorrectTextContentOfMainBanner() {

        //given
        Homepage homepageA = new Homepage(driver);

        //when
        homepageA.getMainBannerTopText();
        homepageA.getMainBannerMainText();
        homepageA.getMainBannerButtonText();

        //then
        assertThat(homepageA.getMainBannerTopText()).isEqualTo("New Luma Yoga Collection");
        assertThat(homepageA.getMainBannerMainText()).isEqualTo("Get fit and look fab in new seasonal styles");
        assertThat(homepageA.getMainBannerButtonText()).isEqualTo("Shop New Yoga");


    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}