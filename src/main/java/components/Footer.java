package components;

import enums.Attribute;
import enums.CssProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.ColorUtils.getColorAsHex;

public class Footer {
    private final By footerList = By.cssSelector(".footer.content ul.footer.links li");
    private final By footerWebsiteInformation = By.cssSelector("footer + div");
    private final By subscribeButton = By.cssSelector(".actions .action.subscribe.primary");
    private final By enterEmailInput = By.cssSelector(".field.newsletter #newsletter");
    private final By subscribeFormField = By.cssSelector(".form.subscribe");
    private final By copyrightSection = By.className("copyright");
    private final WebDriver driver;

    public Footer(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getFooterCategoriesList() {
        return driver.findElements(footerList);
    }

    public String getFooterWebsiteInformationText() {
        return driver.findElement(footerWebsiteInformation).getText();
    }

    public String getSubscribeButtonText() {
        return driver.findElement(subscribeButton).getText();
    }

    public boolean isSubscribeButtonEnabled() {
        return driver.findElement(subscribeButton).isEnabled();
    }

    public String getSubscribeButtonBackgroundColorAsHex() {
        return getColorAsHex(driver, subscribeButton, CssProperty.BACKGROUND_COLOR);
    }

    public String getSubscribeButtonFontColorAsHex() {
        return getColorAsHex(driver, subscribeButton, CssProperty.COLOR);
    }

    public String getEnterYourEmailPlaceHolderText() {
        return driver.findElement(enterEmailInput).getAttribute(Attribute.PLACEHOLDER.name());
    }

    public boolean isSubscribeFormFieldDisplayed() {
        return driver.findElement(subscribeFormField).isDisplayed();
    }

    public boolean isCopyrightInformationDisplayed() {
        return driver.findElement(copyrightSection).isDisplayed();
    }

    public String getFooterCopyrightInformationText() {
        return driver.findElement(copyrightSection).getText();
    }
}

