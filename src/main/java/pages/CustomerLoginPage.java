package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerLoginPage {

    private static WebDriver driver;

    public CustomerLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void customerLoginAs (String email, String password) {
        WebElement emailInput = driver.findElement(By.name("login[username]"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);

        WebElement passwordInput =driver.findElement(By.name("login[password]"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement signInbutton = driver.findElement(By.id("send2"));
        signInbutton.click();
    }
}
