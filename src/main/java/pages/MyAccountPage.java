package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void confirmationOfRegistration () {
        WebElement welcomeName = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]"));
        String firstLastName = "Ala Kowalska";
        String userName = welcomeName.getText();
    }
}