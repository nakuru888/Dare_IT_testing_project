package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class ColorUtils {
    public static String getColorAsHex(WebDriver driver, By locator, String propertyName) {
        WebElement element = driver.findElement(locator);
        String colorRgba = element.getCssValue(propertyName);
        return Color.fromString(colorRgba).asHex();
    }
}
