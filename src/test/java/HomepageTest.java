import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Homepage;
import utils.WebDriverUtils;

public class HomepageTest {

    private WebDriver driver;

    private static final String WHITE_COLOR = "#ffffff";
    private static final String BLUE_COLOR = "#1979c3";

    @BeforeClass
    public void setUp() {
        driver = WebDriverUtils.createWebDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Test
    public void homepage_MainBanner_HasTextAndButtonCorrectlyDisplayed() {
        //given
        Homepage homepage = new Homepage(driver);

        //then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(homepage.isMainBannerDisplayed()).isTrue();
        softAssertions.assertThat(homepage.isMainBannerButtonEnabled()).isTrue();
        softAssertions.assertThat(homepage.getMainBannerTopText()).isEqualTo("New Luma Yoga Collection");
        softAssertions.assertThat(homepage.getMainBannerMainText()).isEqualTo("Get fit and look fab in new seasonal styles");
        softAssertions.assertThat(homepage.getMainBannerButtonText()).isEqualTo("Shop New Yoga");
        softAssertions.assertThat(homepage.getMainBannerLink()).isEqualTo("https://magento.softwaretestingboard.com/collections/yoga-new.html");
        softAssertions.assertThat(homepage.getMainBannerImageSource()).isEqualTo("https://magento.softwaretestingboard.com/pub/media/wysiwyg/home/home-main.jpg");
        softAssertions.assertThat(homepage.getMainBannerButtonBackgroundColorAsHex()).isEqualTo(BLUE_COLOR);
        softAssertions.assertThat(homepage.getMainBannerButtonFontColorAsHex()).isEqualTo(WHITE_COLOR);
        softAssertions.assertAll();
    }

    @Test
    public void homepage_PantsBanner_HasTextAndLinkCorrectlyDisplayed() {
        //given
        Homepage homepage = new Homepage(driver);

        //then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(homepage.isPantsBannerDisplayed()).isTrue();
        softAssertions.assertThat(homepage.isPantsLinkEnabled()).isTrue();
        softAssertions.assertThat(homepage.getPantsBannerTopText()).isEqualTo("20% OFF");
        softAssertions.assertThat(homepage.getPantsBannerMainText()).isEqualTo("Luma pants when you shop today*");
        softAssertions.assertThat(homepage.getPantsBannerBottomText()).isEqualTo("Shop Pants");
        softAssertions.assertThat(homepage.getPantsBannerLink())
                .isEqualTo("https://magento.softwaretestingboard.com/promotions/pants-all.html");
        softAssertions.assertThat(homepage.getPantsBannerImageSource())
                .isEqualTo("https://magento.softwaretestingboard.com/pub/media/wysiwyg/home/home-pants.jpg");
        softAssertions.assertAll();
    }

    @Test
    public void homepage_TeesBanner_HasTextAndLinkCorrectlyDisplayed() {
        //given
        Homepage homepage = new Homepage(driver);

        //then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(homepage.isTeesBannerDisplayed()).isTrue();
        softAssertions.assertThat(homepage.isTeesLinkEnabled()).isTrue();
        softAssertions.assertThat(homepage.getTeesBannerTopText()).isEqualTo("Even more ways to mix and match");
        softAssertions.assertThat(homepage.getTeesBannerMainText()).isEqualTo("Buy 3 Luma tees get a 4th free");
        softAssertions.assertThat(homepage.getTeesBannerBottomText()).isEqualTo("Shop Tees");
        softAssertions.assertThat(homepage.getTeesBannerLink())
                .isEqualTo("https://magento.softwaretestingboard.com/promotions/tees-all.html");
        softAssertions.assertThat(homepage.getTeesBannerImageSource())
                .isEqualTo("https://magento.softwaretestingboard.com/pub/media/wysiwyg/home/home-t-shirts.png");
        softAssertions.assertAll();
    }

    @Test
    public void homepage_ErinBanner_HasTextAndLinkCorrectlyDisplayed() {
        //given
        Homepage homepage = new Homepage(driver);

        //then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(homepage.isErinBannerDisplayed()).isTrue();
        softAssertions.assertThat(homepage.isErinLinkEnabled()).isTrue();
        softAssertions.assertThat(homepage.getErinBannerTopText()).isEqualTo("Take it from Erin");
        softAssertions.assertThat(homepage.getErinBannerMainText()).isEqualTo("Luma founder Erin Renny shares her favorites!");
        softAssertions.assertThat(homepage.getErinBannerBottomText()).isEqualTo("Shop Erin Recommends");
        softAssertions.assertThat(homepage.getErinBannerLink())
                .isEqualTo("https://magento.softwaretestingboard.com/collections/erin-recommends.html");
        softAssertions.assertThat(homepage.getErinBannerImageSource())
                .isEqualTo("https://magento.softwaretestingboard.com/pub/media/wysiwyg/home/home-erin.jpg");
        softAssertions.assertAll();
    }

    @Test
    public void homepage_EcoFriendlyBanner_HasTextAndLinkCorrectlyDisplayed() {
        //given
        Homepage homepage = new Homepage(driver);

        //then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(homepage.isEcoFriendlyBannerDisplayed()).isTrue();
        softAssertions.assertThat(homepage.isEcoFriendlyLinkEnabled()).isTrue();
        softAssertions.assertThat(homepage.getEcoFriendlyBannerTopText()).isEqualTo("Twice around, twice as nice");
        softAssertions.assertThat(homepage.getEcoFriendlyBannerMainText()).isEqualTo("Find conscientious, comfy clothing in our eco-friendly collection");
        softAssertions.assertThat(homepage.getEcoFriendlyBannerBottomText()).isEqualTo("Shop Eco-Friendly");
        softAssertions.assertThat(homepage.getEcoFriendlyBannerLink())
                .isEqualTo("https://magento.softwaretestingboard.com/collections/eco-friendly.html");
        softAssertions.assertThat(homepage.getEcoFriendlyBannerImageSource())
                .isEqualTo("https://magento.softwaretestingboard.com/pub/media/wysiwyg/home/home-eco.jpg");
        softAssertions.assertAll();
    }

    @Test
    public void homepage_PerformanceBanner_HasTextAndLinkCorrectlyDisplayed() {
        //given
        Homepage homepage = new Homepage(driver);

        //then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(homepage.isPerformanceBannerDisplayed()).isTrue();
        softAssertions.assertThat(homepage.isPerformanceLinkEnabled()).isTrue();
        softAssertions.assertThat(homepage.getPerformanceBannerTopText()).isEqualTo("Science meets performance");
        softAssertions.assertThat(homepage.getPerformanceBannerMainText()).isEqualTo("Wicking to raingear, Luma covers you");
        softAssertions.assertThat(homepage.getPerformanceBannerBottomText()).isEqualTo("Shop Performance");
        softAssertions.assertThat(homepage.getPerformanceBannerLink())
                .isEqualTo("https://magento.softwaretestingboard.com/collections/performance-fabrics.html");
        softAssertions.assertThat(homepage.getPerformanceBannerImageSource())
                .isEqualTo("https://magento.softwaretestingboard.com/pub/media/wysiwyg/home/home-performance.jpg");
        softAssertions.assertAll();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

