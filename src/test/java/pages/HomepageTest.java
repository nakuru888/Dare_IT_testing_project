package pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Homepage;
import utils.WebDriverUtils;

import java.util.List;

import static colors.ColorsHex.BLUE_COLOR;
import static colors.ColorsHex.WHITE_COLOR;
import static page.url.PageUrl.HOMEPAGE_URL;

public class
HomepageTest {
    private WebDriver driver;
    private Homepage homepage;

    @BeforeClass
    public void setUp() {
        driver = WebDriverUtils.createWebDriver();
        driver.get(HOMEPAGE_URL);
        homepage = new Homepage(driver);
    }

    @Test
    public void homepage_MainBanner_HasTextAndButtonCorrectlyDisplayed() {
        //then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(homepage.isMainBannerDisplayed()).isTrue();
        softAssertions.assertThat(homepage.isMainBannerButtonEnabled()).isTrue();
        softAssertions.assertThat(homepage.getMainBannerTopText()).isEqualTo("New Luma Yoga Collection");
        softAssertions.assertThat(homepage.getMainBannerMainText()).isEqualTo("Get fit and look fab in new seasonal styles");
        softAssertions.assertThat(homepage.getMainBannerButtonText()).isEqualTo("Shop New Yoga");
        softAssertions.assertThat(homepage.getMainBannerLink()).isEqualTo(HOMEPAGE_URL + "collections/yoga-new.html");
        softAssertions.assertThat(homepage.getMainBannerImageSource()).isEqualTo(HOMEPAGE_URL + "pub/media/wysiwyg/home/home-main.jpg");
        softAssertions.assertThat(homepage.getMainBannerButtonBackgroundColorAsHex()).isEqualTo(BLUE_COLOR);
        softAssertions.assertThat(homepage.getMainBannerButtonFontColorAsHex()).isEqualTo(WHITE_COLOR);
        softAssertions.assertAll();
    }

    @Test
    public void homepage_PantsBanner_HasTextAndLinkCorrectlyDisplayed() {
        //then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(homepage.isPantsBannerDisplayed()).isTrue();
        softAssertions.assertThat(homepage.isPantsLinkEnabled()).isTrue();
        softAssertions.assertThat(homepage.getPantsBannerTopText()).isEqualTo("20% OFF");
        softAssertions.assertThat(homepage.getPantsBannerMainText()).isEqualTo("Luma pants when you shop today*");
        softAssertions.assertThat(homepage.getPantsBannerBottomText()).isEqualTo("Shop Pants");
        softAssertions.assertThat(homepage.getPantsBannerLink()).isEqualTo(HOMEPAGE_URL + "promotions/pants-all.html");
        softAssertions.assertThat(homepage.getPantsBannerImage()).isEqualTo(HOMEPAGE_URL + "pub/media/wysiwyg/home/home-pants.jpg");
        softAssertions.assertAll();
    }

    @Test
    public void homepage_TeesBanner_HasTextAndLinkCorrectlyDisplayed() {
        //then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(homepage.isTeesBannerDisplayed()).isTrue();
        softAssertions.assertThat(homepage.isTeesLinkEnabled()).isTrue();
        softAssertions.assertThat(homepage.getTeesBannerTopText()).isEqualTo("Even more ways to mix and match");
        softAssertions.assertThat(homepage.getTeesBannerMainText()).isEqualTo("Buy 3 Luma tees get a 4th free");
        softAssertions.assertThat(homepage.getTeesBannerBottomText()).isEqualTo("Shop Tees");
        softAssertions.assertThat(homepage.getTeesBannerLink()).isEqualTo(HOMEPAGE_URL + "promotions/tees-all.html");
        softAssertions.assertThat(homepage.getTeesBannerImage()).isEqualTo(HOMEPAGE_URL + "pub/media/wysiwyg/home/home-t-shirts.png");
        softAssertions.assertAll();
    }

    @Test
    public void homepage_ErinBanner_HasTextAndLinkCorrectlyDisplayed() {
        //then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(homepage.isErinBannerDisplayed()).isTrue();
        softAssertions.assertThat(homepage.isErinLinkEnabled()).isTrue();
        softAssertions.assertThat(homepage.getErinBannerTopText()).isEqualTo("Take it from Erin");
        softAssertions.assertThat(homepage.getErinBannerMainText()).isEqualTo("Luma founder Erin Renny shares her favorites!");
        softAssertions.assertThat(homepage.getErinBannerBottomText()).isEqualTo("Shop Erin Recommends");
        softAssertions.assertThat(homepage.getErinBannerLink()).isEqualTo(HOMEPAGE_URL + "collections/erin-recommends.html");
        softAssertions.assertThat(homepage.getErinBannerImage()).isEqualTo(HOMEPAGE_URL + "pub/media/wysiwyg/home/home-erin.jpg");
        softAssertions.assertAll();
    }

    @Test
    public void homepage_EcoFriendlyBanner_HasTextAndLinkCorrectlyDisplayed() {
        //then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(homepage.isEcoFriendlyBannerDisplayed()).isTrue();
        softAssertions.assertThat(homepage.isEcoFriendlyLinkEnabled()).isTrue();
        softAssertions.assertThat(homepage.getEcoFriendlyBannerTopText()).isEqualTo("Twice around, twice as nice");
        softAssertions.assertThat(homepage.getEcoFriendlyBannerMainText()).isEqualTo("Find conscientious, comfy clothing in our eco-friendly collection");
        softAssertions.assertThat(homepage.getEcoFriendlyBannerBottomText()).isEqualTo("Shop Eco-Friendly");
        softAssertions.assertThat(homepage.getEcoFriendlyBannerLink()).isEqualTo(HOMEPAGE_URL + "collections/eco-friendly.html");
        softAssertions.assertThat(homepage.getEcoFriendlyBannerImage()).isEqualTo(HOMEPAGE_URL + "pub/media/wysiwyg/home/home-eco.jpg");
        softAssertions.assertAll();
    }

    @Test
    public void homepage_PerformanceBanner_HasTextAndLinkCorrectlyDisplayed() {
        //then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(homepage.isPerformanceBannerDisplayed()).isTrue();
        softAssertions.assertThat(homepage.isPerformanceLinkEnabled()).isTrue();
        softAssertions.assertThat(homepage.getPerformanceBannerTopText()).isEqualTo("Science meets performance");
        softAssertions.assertThat(homepage.getPerformanceBannerMainText()).isEqualTo("Wicking to raingear, Luma covers you");
        softAssertions.assertThat(homepage.getPerformanceBannerBottomText()).isEqualTo("Shop Performance");
        softAssertions.assertThat(homepage.getPerformanceBannerLink()).isEqualTo(HOMEPAGE_URL + "collections/performance-fabrics.html");
        softAssertions.assertThat(homepage.getPerformanceBannerImage()).isEqualTo(HOMEPAGE_URL + "pub/media/wysiwyg/home/home-performance.jpg");
        softAssertions.assertAll();
    }

    @Test
    public void homepage_HotSellers_HasTextAndTrendingProductsCorrectlyDisplayed() {
        //given
        List<WebElement> hotSellerProductsWebElementList = homepage.getHotSellersProductsList();

        //then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(homepage.isHotSellersTitleDisplayed()).isTrue();
        softAssertions.assertThat(homepage.isWhatIsTrendingTextDisplayed()).isTrue();
        softAssertions.assertThat(homepage.getHotSellersTitleText()).isEqualTo("Hot Sellers");
        softAssertions.assertThat(homepage.getWhatIsTrendingText()).isEqualTo("Here is what`s trending on Luma right now");
        for (WebElement element : hotSellerProductsWebElementList) {
            softAssertions.assertThat(element.findElement(Homepage.HOT_SELLERS_PRODUCT_TITLE).isDisplayed()).isTrue();
            softAssertions.assertThat(element.findElement(Homepage.HOT_SELLERS_PRODUCT_IMAGE).isDisplayed()).isTrue();
            softAssertions.assertThat(element.findElement(Homepage.HOT_SELLERS_PRODUCT_DETAILS).isDisplayed()).isTrue();
        }
        softAssertions.assertAll();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

