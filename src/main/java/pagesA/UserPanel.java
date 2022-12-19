package pagesA;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utilsA.WaitUtilsA.waitUntilElementsIsPresented;

@Getter
public class UserPanel {
    private final By pageTitle = By.cssSelector("h1 span");
    private final WebDriver driver;

    public UserPanel(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        waitUntilElementsIsPresented(driver, pageTitle, 5);
        return driver.findElement(pageTitle).getText();
    }
    //co tutaj sie dzieje - co to jest Getter, co on robi i po co ta metoda?
}
