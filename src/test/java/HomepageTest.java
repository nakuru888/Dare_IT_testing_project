import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Homepage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class HomepageTest {

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
    public void homepage_MainBanner_HasTextAndButtonCorrectlyDisplayed() {
        //given
        Homepage homepage = new Homepage(driver);

        //then
        assertThat(homepage.getMainBannerTopText()).isEqualTo("New Luma Yoga Collection");
        assertThat(homepage.getMainBannerMainText()).isEqualTo("Get fit and look fab in new seasonal styles");
        assertThat(homepage.getMainBannerButtonText()).isEqualTo("Shop New Yoga");
        assertThat(driver.findElement(By.cssSelector(".blocks-promo > a")).getAttribute("href")).
                isEqualTo("https://magento.softwaretestingboard.com/collections/yoga-new.html");
        assertThat(driver.findElement(By.cssSelector(".blocks-promo > a img")).getAttribute("src")).
                isEqualTo("https://magento.softwaretestingboard.com/pub/media/wysiwyg/home/home-main.jpg");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}

