package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {

    private final By emailInputBy = By.id("email");

    private final By passwordInputBy = By.id("pass");
    private final By signInButton = By.id("send2");


    private final WebDriver driver;

    public Loginpage(WebDriver driver) {

        this.driver = driver;
    }


    public Homepage loginWithEmailAndPassword(String email, String password) {
        fillInInputField(driver.findElement(emailInputBy), email);
        fillInInputField(driver.findElement(passwordInputBy), password);
        driver.findElement(signInButton).click();
        return new Homepage(driver);

    }

    private void fillInInputField(WebElement element, String inputData) {
        element.click();
        element.clear();
        element.sendKeys(inputData);

    }


}