package utils;

import enums.CssProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class ColorUtils {
    public static String getColorAsHex(WebDriver driver, By locator, CssProperty cssProperty) {
        WebElement element = driver.findElement(locator);
        String colorRgba = element.getCssValue(cssProperty.getPropertyName());
        return Color.fromString(colorRgba).asHex();
    }
}
