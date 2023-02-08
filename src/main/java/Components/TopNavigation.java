package Components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TopNavigation {
    private final By menuBarList = By.cssSelector(".navigation li.level0");

    private final WebDriver driver;

    public TopNavigation(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getTopCategoriesList() {
        return driver.findElements(menuBarList);
    }

    public void hoverOnCategory(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
}
