package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static utils.WaitUtils.waitUntilElementsIsPresented;

public class TopNavigation {
    private final By menuBarList = By.cssSelector(".navigation li.level0");
    private final By caretIconTopNavigationBar = By.cssSelector("#ui-id-4 .ui-menu-icon.ui-icon.ui-icon-carat-1-e");

    private final WebDriver driver;

    public TopNavigation(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getTopCategoriesList() {
        return driver.findElements(menuBarList);
    }

    public void hoverOnCategory(WebElement element) {
        waitUntilElementsIsPresented(driver, caretIconTopNavigationBar, 5);
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
}
