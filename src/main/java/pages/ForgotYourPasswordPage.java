package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotYourPasswordPage {

    private final WebDriver driver;

    public ForgotYourPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By pageTitle = By.cssSelector("h1 span");

    public String getPageTitle(){
        return driver.findElement(pageTitle).getText();
    }
}
