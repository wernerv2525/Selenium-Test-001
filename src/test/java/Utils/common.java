package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Tests.SeleniumTest.driver;

public class common {

    public static void wait_for_element_xpath(String args){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(args)));
    }

    public static void wait_for_element_to_be_enable(String locatorType, String locatorValue){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By locator = switch (locatorType.toLowerCase()) {
            case "id" -> By.id(locatorValue);
            case "xpath" -> By.xpath(locatorValue);
            case "css" -> By.cssSelector(locatorValue);
            default -> throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        };
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
