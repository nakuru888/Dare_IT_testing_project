package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Loginpage;


import static utils.WaitUtils.waitUntilElementContainsText;
import static utils.WaitUtils.waitUntilElementsIsPresented;

public class Homepage {
    private final By createAccountHeaderLink = By.cssSelector(".header.links:list-child");

    private final By signInHeaderLink = By.cssSelector(".header.links .authorization-link");
    private final By welcomeText = By.className("logged-in");

    private final By mainBannerTopText = By.cssSelector("span[class='info']");
    private final By mainBannerMainText = By.cssSelector("strong[class='title']");
    private final By mainBannerButtonText = By.className(".action.more.button");
    private final By mainBanner = By.className("block-promo home-main");

    private final WebDriver driver;

    public Homepage(WebDriver driver) {

        this.driver = driver;
    }

    public CreateAccountPage openCreateAccountPage() {
        driver.findElement(createAccountHeaderLink).click();
        return new CreateAccountPage(driver);


    }

    public Loginpage openLoginPage() {
        driver.findElement(signInHeaderLink).click();
        return new Loginpage(driver);
    }

    public String getWelcomeText() {
        waitUntilElementContainsText(driver, welcomeText, "Welcome");
        return driver.findElement(welcomeText).getText();


    }

    public String getMainBannerTopText() {
        return driver.findElement(mainBannerTopText).getText();
    }

    public String getMainBannerMainText() {
        return driver.findElement(mainBannerMainText).getText();
    }

    public String getMainBannerButtonText() {
        return driver.findElement(mainBannerButtonText).getText();
    }

    public String checkIfMainBannerIsDisplayed() {
        waitUntilElementsIsPresented(driver, mainBanner, 10);
        return driver.findElement(mainBanner).getText();
    }
}
