package pagesA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginpageA {
    //co to jest final? czemu jest przy driver i elementach, czemu konstruktor i driver jest na końcu?

    private final By emailInputBy = By.id("email");
    //co z konstrukacją Webelement/driver.FindElement - to jest to samo tylko krócej? to "By" jest kluczowe?
    private final By passwordInputBy = By.id("pass");
    private final By signInButton = By.id("send2");
    private final WebDriver driver;

    public LoginpageA(WebDriver driver) {

        this.driver = driver;
    }


    public HomepageA loginWithEmailAndPassword(String email, String password) {
        fillInInputField(driver.findElement(emailInputBy), email);
        fillInInputField(driver.findElement(passwordInputBy), password);
        driver.findElement(signInButton).click();
        return new HomepageA(driver);

        //czemu to jest Homepage? co z kilknieciem w Sigin In zeby dostac sie do logowania - od razu od tego zaczynamy?
        // co Homepage tutaj robi- jest klasa a gdzie ona jest i co robi? do czego sie odwoluje? czemu po przecinku jest email i password co to robi?
        //o co chodzi z return?
    }

    private void fillInInputField(WebElement element, String inputData) {
        element.click();
        element.clear();
        element.sendKeys(inputData);

        //skad wie w jaki element kliknąc skoro jest sam element, czemu sa argumenty w metodzie?
    }
}