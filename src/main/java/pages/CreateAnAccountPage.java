package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.*;

public class CreateAnAccountPage {

    private WebDriver driver;

    public CreateAnAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInTheForm (String firstname, String lastname, String email, String password, String confirmPassword) throws InterruptedException {
        WebElement firstNameF = driver.findElement(By.id("firstname"));
        WebElement lastNameF = driver.findElement(By.id("lastname"));
        WebElement emailF= driver.findElement(By.name("email"));
        WebElement passwordF = driver.findElement(By.name("password"));
        WebElement confirmPasswordF = driver.findElement(By.name("password_confirmation"));

        firstNameF.click();
        firstNameF.clear();
        firstNameF.sendKeys(firstname);
        Thread.sleep(2000);

        lastNameF.click();
        lastNameF.clear();
        lastNameF.sendKeys(lastname);
        Thread.sleep(2000);

        emailF.click();
        emailF.clear();
        emailF.sendKeys(email);
        Thread.sleep(2000);

        passwordF.click();
        passwordF.clear();
        passwordF.sendKeys(password);
        Thread.sleep(2000);

        confirmPasswordF.click();
        confirmPasswordF.clear();
        confirmPasswordF.sendKeys(confirmPassword);

    }

    public void createAnAccountButton () {
        WebElement clickButton = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span"));
        clickButton.click();
    }



}
