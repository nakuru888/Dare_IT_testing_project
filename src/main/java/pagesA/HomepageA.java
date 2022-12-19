package pagesA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static utilsA.WaitUtilsA.waitUntilElementContainsText;

public class HomepageA {
    private final By createAccountHeaderLink = By.cssSelector(".header.links:list-child");
    //jak zbudowalas taki selektor?
    private final By signInHeaderLink = By.cssSelector(".header.links .authorization-link");
    private final By welcomeText = By.className("logged-in");
    private final WebDriver driver;

    public HomepageA(WebDriver driver) {

        this.driver = driver;
    }

    public CreateAccountPageA openCreateAccountPage() {
        driver.findElement(createAccountHeaderLink).click();
        return new CreateAccountPageA(driver);

        //czemu CreateAccountPage tutaj?
        //o co chodzi z return new ...
    }

    public LoginpageA openLoginPage() {
        driver.findElement(signInHeaderLink).click();
        return new LoginpageA(driver);
    }

    public String getWelcomeText() {
        waitUntilElementContainsText(driver, welcomeText, "Welcome");
        return driver.findElement(welcomeText).getText();

        //argumenty w metodzie - return o co chodzi?
    }
}
