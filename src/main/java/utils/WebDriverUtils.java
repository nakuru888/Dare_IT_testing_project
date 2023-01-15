package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class WebDriverUtils {
    public static WebDriver createWebDriver(int durationInSeconds) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(durationInSeconds));
        return driver;
    }

    public static WebDriver createWebDriver() {
        return createWebDriver(5);
    }
}
