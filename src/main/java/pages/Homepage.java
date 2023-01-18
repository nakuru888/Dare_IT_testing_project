package pages;

import enums.Attribute;
import enums.CssProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.ColorUtils.getColorAsHex;
import static utils.WaitUtils.waitUntilElementContainsText;
import static utils.WaitUtils.waitUntilElementsIsPresented;

public class Homepage {
    public static final By HOT_SELLERS_PRODUCT_IMAGE = By.className("product-image-photo");
    public static final By HOT_SELLERS_PRODUCT_DETAILS = By.className("product-item-details");
    public static final By HOT_SELLERS_PRODUCT_TITLE = By.className("product-item-name");
    private final By createAccountHeaderLink = By.cssSelector(".panel.header .header.links li:last-child");
    private final By signInHeaderLink = By.cssSelector(".header.links .authorization-link");
    private final By welcomeText = By.className("logged-in");
    private final By mainBannerTopText = By.cssSelector(".blocks-promo .home-main .info");
    private final By mainBannerMainText = By.cssSelector(".blocks-promo .home-main .title");
    private final By mainBannerButton = By.cssSelector(".action.more.button");
    private final By mainBanner = By.cssSelector(".block-promo.home-main");
    private final By mainBannerLink = By.cssSelector(".blocks-promo > a");
    private final By mainBannerImageSource = By.cssSelector(".blocks-promo > a img");
    private final By pantsBanner = By.cssSelector(".block-promo.home-pants");
    private final By pantsBannerTopText = By.cssSelector(".home-pants .content .title");
    private final By pantsBannerMainText = By.cssSelector(".home-pants .content .info");
    private final By pantsBannerBottomText = By.cssSelector(".home-pants .content .action");
    private final By pantsBannerImage = By.cssSelector(".block-promo.home-pants > img");
    private final By teesBanner = By.cssSelector(".block-promo.home-t-shirts");
    private final By teesBannerTopText = By.cssSelector(".block-promo.home-t-shirts .content .title");
    private final By teesBannerMainText = By.cssSelector(".block-promo.home-t-shirts .content .info");
    private final By teesBannerBottomText = By.cssSelector(".block-promo.home-t-shirts .content .action");
    private final By teesBannerImage = By.cssSelector(".block-promo.home-t-shirts .image > img");
    private final By erinBanner = By.cssSelector(".block-promo.home-erin");
    private final By erinBannerTopText = By.cssSelector(".block-promo.home-erin .title");
    private final By erinBannerMainText = By.cssSelector(".block-promo.home-erin .info");
    private final By erinBannerBottomText = By.cssSelector(".block-promo.home-erin .action");
    private final By erinBannerImage = By.cssSelector(".block-promo.home-erin > img");
    private final By ecoFriendlyBanner = By.cssSelector(".block-promo.home-eco");
    private final By ecoFriendlyBannerTopText = By.cssSelector(".block-promo.home-eco .title");
    private final By ecoFriendlyBannerMainText = By.cssSelector(".block-promo.home-eco .info");
    private final By ecoFriendlyBannerBottomText = By.cssSelector(".block-promo.home-eco .action");
    private final By ecoFriendlyBannerImage = By.cssSelector(".block-promo.home-eco > img");
    private final By performanceBanner = By.cssSelector(".block-promo.home-performance");
    private final By performanceBannerTopText = By.cssSelector(".block-promo.home-performance .title");
    private final By performanceBannerMainText = By.cssSelector(".block-promo.home-performance .info");
    private final By performanceBannerBottomText = By.cssSelector(".block-promo.home-performance .action");
    private final By performanceBannerImage = By.cssSelector(".block-promo.home-performance > img");
    private final By hotSellersTitle = By.cssSelector(".content-heading .title");
    private final By whatIsTrendingText = By.cssSelector(".content-heading .info");
    private final By hotSellersProductsList = By.cssSelector(".product-items.widget-product-grid");

    private final WebDriver driver;

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    public CreateAccountPage openCreateAccountPage() {
        driver.findElement(createAccountHeaderLink).click();
        return new CreateAccountPage(driver);
    }

    public LoginPage openLoginPage() {
        driver.findElement(signInHeaderLink).click();
        return new LoginPage(driver);
    }

    public String getWelcomeText() {
        waitUntilElementContainsText(driver, welcomeText, "Welcome");
        return driver.findElement(welcomeText).getText();
    }

    public String getMainBannerTopText() {
        waitUntilMainBannerIsDisplayed();
        return driver.findElement(mainBannerTopText).getText();
    }

    public String getMainBannerMainText() {
        return driver.findElement(mainBannerMainText).getText();
    }

    public String getMainBannerButtonText() {
        return driver.findElement(mainBannerButton).getText();
    }

    public void waitUntilMainBannerIsDisplayed() {
        waitUntilElementsIsPresented(driver, mainBanner, 10);
    }

    public String getMainBannerLink() {
        return driver.findElement(mainBannerLink).getAttribute(Attribute.HREF.name().toLowerCase());
    }

    public String getMainBannerImageSource() {
        return driver.findElement(mainBannerImageSource).getAttribute(Attribute.SRC.name().toLowerCase());
    }

    public boolean isMainBannerDisplayed() {
        return driver.findElement(mainBanner).isDisplayed();
    }

    public boolean isMainBannerButtonEnabled() {
        return driver.findElement(mainBannerButton).isEnabled();
    }

    public String getMainBannerButtonFontColorAsHex() {
        return getColorAsHex(driver, mainBannerButton, CssProperty.COLOR);
    }

    public String getMainBannerButtonBackgroundColorAsHex() {
        return getColorAsHex(driver, mainBannerButton, CssProperty.BACKGROUND_COLOR);
    }

    public boolean isPantsBannerDisplayed() {
        return driver.findElement(pantsBanner).isDisplayed();
    }

    public boolean isPantsLinkEnabled() {
        return driver.findElement(pantsBanner).isEnabled();
    }

    public String getPantsBannerTopText() {
        return driver.findElement(pantsBannerTopText).getText();
    }

    public String getPantsBannerMainText() {
        return driver.findElement(pantsBannerMainText).getText();
    }

    public String getPantsBannerBottomText() {
        return driver.findElement(pantsBannerBottomText).getText();
    }

    public String getPantsBannerLink() {
        return driver.findElement(pantsBanner).getAttribute(Attribute.HREF.name());
    }

    public String getPantsBannerImage() {
        return driver.findElement(pantsBannerImage).getAttribute(Attribute.SRC.name());
    }

    public boolean isTeesBannerDisplayed() {
        return driver.findElement(teesBanner).isDisplayed();
    }

    public boolean isTeesLinkEnabled() {
        return driver.findElement(teesBanner).isEnabled();
    }

    public String getTeesBannerTopText() {
        return driver.findElement(teesBannerTopText).getText();
    }

    public String getTeesBannerMainText() {
        return driver.findElement(teesBannerMainText).getText();
    }

    public String getTeesBannerBottomText() {
        return driver.findElement(teesBannerBottomText).getText();
    }

    public String getTeesBannerLink() {
        return driver.findElement(teesBanner).getAttribute(Attribute.HREF.name());
    }

    public String getTeesBannerImage() {
        return driver.findElement(teesBannerImage).getAttribute(Attribute.SRC.name());
    }

    public boolean isErinBannerDisplayed() {
        return driver.findElement(erinBanner).isDisplayed();
    }

    public boolean isErinLinkEnabled() {
        return driver.findElement(erinBanner).isEnabled();
    }

    public String getErinBannerTopText() {
        return driver.findElement(erinBannerTopText).getText();
    }

    public String getErinBannerMainText() {
        return driver.findElement(erinBannerMainText).getText();
    }

    public String getErinBannerBottomText() {
        return driver.findElement(erinBannerBottomText).getText();
    }

    public String getErinBannerLink() {
        return driver.findElement(erinBanner).getAttribute(Attribute.HREF.name());
    }

    public String getErinBannerImage() {
        return driver.findElement(erinBannerImage).getAttribute(Attribute.SRC.name());
    }

    public boolean isEcoFriendlyBannerDisplayed() {
        return driver.findElement(ecoFriendlyBanner).isDisplayed();
    }

    public boolean isEcoFriendlyLinkEnabled() {
        return driver.findElement(ecoFriendlyBanner).isEnabled();
    }

    public String getEcoFriendlyBannerTopText() {
        return driver.findElement(ecoFriendlyBannerTopText).getText();
    }

    public String getEcoFriendlyBannerMainText() {
        return driver.findElement(ecoFriendlyBannerMainText).getText();
    }

    public String getEcoFriendlyBannerBottomText() {
        return driver.findElement(ecoFriendlyBannerBottomText).getText();
    }

    public String getEcoFriendlyBannerLink() {
        return driver.findElement(ecoFriendlyBanner).getAttribute(Attribute.HREF.name());
    }

    public String getEcoFriendlyBannerImage() {
        return driver.findElement(ecoFriendlyBannerImage).getAttribute(Attribute.SRC.name());
    }

    public boolean isPerformanceBannerDisplayed() {
        return driver.findElement(performanceBanner).isDisplayed();
    }

    public boolean isPerformanceLinkEnabled() {
        return driver.findElement(performanceBanner).isEnabled();
    }

    public String getPerformanceBannerTopText() {
        return driver.findElement(performanceBannerTopText).getText();
    }

    public String getPerformanceBannerMainText() {
        return driver.findElement(performanceBannerMainText).getText();
    }

    public String getPerformanceBannerBottomText() {
        return driver.findElement(performanceBannerBottomText).getText();
    }

    public String getPerformanceBannerLink() {
        return driver.findElement(performanceBanner).getAttribute(Attribute.HREF.name());
    }

    public String getPerformanceBannerImage() {
        return driver.findElement(performanceBannerImage).getAttribute(Attribute.SRC.name());
    }

    public boolean isHotSellersTitleDisplayed() {
        return driver.findElement(hotSellersTitle).isDisplayed();
    }

    public String getHotSellersTitleText() {
        return driver.findElement(hotSellersTitle).getText();
    }

    public boolean isWhatIsTrendingTextDisplayed() {
        return driver.findElement(whatIsTrendingText).isDisplayed();
    }

    public String getWhatIsTrendingText() {
        return driver.findElement(whatIsTrendingText).getText();
    }

    public List<WebElement> getHotSellersProductsList() {
        return driver.findElements(hotSellersProductsList);
    }
}
