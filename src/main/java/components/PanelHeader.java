package components;

import enums.Attribute;
import enums.CssProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CreateAccountPage;
import pages.LoginPage;


import java.util.List;

import static utils.ColorUtils.getColorAsHex;

public class PanelHeader {
    private final WebDriver driver;

    public PanelHeader(WebDriver driver) {
        this.driver = driver;
    }

    private final By createAccountHeaderLink = By.cssSelector(".panel.header .header.links li:last-child");
    private final By signInHeaderLink = By.cssSelector(".header.links .authorization-link");
    private final By thisIsDemoSiteSection = By.cssSelector(".message.global.demo");
    private final By thisIsDemoSiteSectionText = By.cssSelector(".message.global.demo .content");
    private final By greyBarPageWrapper = By.cssSelector(".panel.wrapper");
    private final By greyBarPageWrapperList = By.cssSelector(".panel .header .links li a");
    private final By lumaLogoLink = By.cssSelector(".header.content a");
    private final By lumaLogoImage = By.cssSelector(".header.content img");
    private final By searchField = By.cssSelector(".field.search .control");
    private final By searchFieldInput = By.cssSelector(".field.search .control input");
    private final By shoppingCartIconLink = By.cssSelector(".action.showcart");


    public CreateAccountPage openCreateAccountPage() {
        driver.findElement(createAccountHeaderLink).click();
        return new CreateAccountPage(driver);
    }

    public LoginPage openLoginPage() {
        driver.findElement(signInHeaderLink).click();
        return new LoginPage(driver);
    }

    public boolean isThisIsDemoSiteSectionDisplayed() {
        return driver.findElement(thisIsDemoSiteSection).isDisplayed();
    }

    public String getThisIsDemoSiteSectionBackgroundAsHex() {
        return getColorAsHex(driver, thisIsDemoSiteSection, CssProperty.BACKGROUND_COLOR);
    }

    public String getThisIsDemoSiteSectionFontAsHex() {
        return getColorAsHex(driver, thisIsDemoSiteSectionText, CssProperty.COLOR);
    }

    public boolean isPanelHeaderSectionDisplayed() {
        return driver.findElement(greyBarPageWrapper).isDisplayed();
    }

    public String getThisIsDemoSiteSectionText() {
        return driver.findElement(thisIsDemoSiteSectionText).getText();
    }

    public String getPanelHeaderSectionBackgroundAsHex() {
        return getColorAsHex(driver, greyBarPageWrapper, CssProperty.BACKGROUND_COLOR);
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
        return driver.findElements(greyBarPageWrapperList);
    }

    public boolean isSearchFieldDisplayed() {
        return driver.findElement(searchField).isDisplayed();
    }

    public String getSearchFieldPlaceHolderText() {
        return driver.findElement(searchFieldInput).getAttribute(Attribute.PLACEHOLDER.name());
    }

    public String getSearchCartLink() {
        return driver.findElement(shoppingCartIconLink).getAttribute(Attribute.HREF.name().toLowerCase());
    }

}
