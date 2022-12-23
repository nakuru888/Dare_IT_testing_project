package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;


import static utils.WaitUtils.waitUntilElementContainsText;
import static utils.WaitUtils.waitUntilElementsIsPresented;

public class Homepage {
    //private final By createAccountHeaderLink = By.cssSelector(".header.links:list-child");
    private final By createAccountHeaderLink = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a");
    private final By signInHeaderLink = By.cssSelector(".header.links .authorization-link");
    private final By welcomeText = By.className("logged-in");
    private final By mainBannerTopText = By.cssSelector(".info");
    private final By mainBannerMainText = By.cssSelector(".title");
    private final By mainBannerButtonText = By.cssSelector(".action.more.button");
    private final By mainBanner = By.cssSelector(".block-promo.home-main");

    private final WebDriver driver;

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }
    public CreateAccountPage openCreateAccountPage() {
        driver.findElement(createAccountHeaderLink).click();
        return new CreateAccountPage(driver);
    }

    public LoginPage openLoginPage() {
        driver.findElement(signInHeaderLink).click();
        return new LoginPage(driver);
    }

    public String getWelcomeText() {
        waitUntilElementContainsText(driver, welcomeText, "Welcome");
        return driver.findElement(welcomeText).getText();
    }

    public String getMainBannerTopText() {
        waitUntilMainBannerIsDisplayed();
        return driver.findElement(mainBannerTopText).getText();
    }

    public String getMainBannerMainText() {
        return driver.findElement(mainBannerMainText).getText();
    }

    public String getMainBannerButtonText() {
        return driver.findElement(mainBannerButtonText).getText();
    }

    public void waitUntilMainBannerIsDisplayed() {
        waitUntilElementsIsPresented(driver, mainBanner, 10);
        }

  }
