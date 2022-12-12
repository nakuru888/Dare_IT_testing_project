package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    private static WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createAnAccountButton() {
        WebElement createAccount = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a"));
        createAccount.click();
    }

    public void loginAsButton () {
        WebElement signIn = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
        signIn.click();
    }

    public String getLoggedUsername () {
        WebElement userName = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span"));
        return userName.getText();

    }

}

