package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.WaitUtils.waitUntilElementsIsPresented;

@Getter
public class UserPanel {
    private final By pageTitle = By.cssSelector("h1 span");
    private final WebDriver driver;

    public UserPanel(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        waitUntilElementsIsPresented(driver, pageTitle, 10);
        return driver.findElement(pageTitle).getText();
    }

}
