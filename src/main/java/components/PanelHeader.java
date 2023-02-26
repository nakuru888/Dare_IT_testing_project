package components;

import enums.Attribute;
import enums.CssProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.ColorUtils.getColorAsHex;
import static utils.WaitUtils.waitUntilElementsIsPresented;

public class PanelHeader {
    private final WebDriver driver;

    public PanelHeader(WebDriver driver) {
        this.driver = driver;
    }

    private final By topDemoInfoBanner = By.cssSelector(".message.global.demo");
    private final By topDemoInfoBannerText = By.cssSelector(".message.global.demo .content");
    private final By greyBarPageWrapperList = By.cssSelector(".panel.wrapper .header.links li a");
    private final By greyBarPageWrapper = By.cssSelector(".panel.wrapper .header.links");
    private final By greyBarPageWrapperContainer = By.cssSelector(".panel.wrapper");
    private final By lumaLogoLink = By.cssSelector(".header.content a");
    private final By lumaLogoImage = By.cssSelector(".header.content img");
    private final By searchField = By.cssSelector(".field.search .control");
    private final By searchFieldInput = By.cssSelector(".field.search .control input");
    private final By shoppingCartIconLink = By.cssSelector(".action.showcart");

    public boolean isTopDemoInfoBannerDisplayed() {
        return driver.findElement(topDemoInfoBanner).isDisplayed();
    }

    public String getTopDemoInfoBannerBackgroundAsHex() {
        return getColorAsHex(driver, topDemoInfoBanner, CssProperty.BACKGROUND_COLOR);
    }

    public String getTopDemoInfoBannerFontAsHex() {
        return getColorAsHex(driver, topDemoInfoBannerText, CssProperty.COLOR);
    }

    public boolean isPanelHeaderSectionDisplayed() {
        return driver.findElement(greyBarPageWrapper).isDisplayed();
    }

    public String getTopDemoInfoBannerText() {
        return driver.findElement(topDemoInfoBannerText).getText();
    }

    public String getPanelHeaderSectionBackgroundAsHex() {
        return getColorAsHex(driver, greyBarPageWrapperContainer, CssProperty.BACKGROUND_COLOR);
    }

    public String getPanelHeaderSectionSectionFontAsHex() {
        return getColorAsHex(driver, greyBarPageWrapper, CssProperty.COLOR);
    }

    public String getLumaLogoLink() {
        return driver.findElement(lumaLogoLink).getAttribute(Attribute.HREF.name().toLowerCase());
    }

    public boolean isLumaLogoDisplayed() {
        return driver.findElement(lumaLogoImage).isDisplayed();
    }

    public String getLumaLogoImageSource() {
        return driver.findElement(lumaLogoImage).getAttribute(Attribute.SRC.name().toLowerCase());
    }

    public List<WebElement> getPanelHeaderList() {
        waitUntilElementsIsPresented(driver, greyBarPageWrapper, 10);
        return driver.findElements(greyBarPageWrapperList);
    }

    public boolean isSearchFieldDisplayed() {
        return driver.findElement(searchField).isDisplayed();
    }

    public String getSearchFieldPlaceHolderText() {
        return driver.findElement(searchFieldInput).getAttribute(Attribute.PLACEHOLDER.name());
    }

    public boolean isCartLinkDisplayed() {
        return driver.findElement(shoppingCartIconLink).isDisplayed();
    }

    public String getCartLink() {
        return driver.findElement(shoppingCartIconLink).getAttribute(Attribute.HREF.name().toLowerCase());
    }

}
