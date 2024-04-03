package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageObject {
    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver){
        this.driver = driver;
    }

    public WebElement waitForElementPresent(By by, String error_message, long timoutSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timoutSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementAndClick(By by, String error_message, long timoutSeconds){
        WebElement element = waitForElementPresent(by, error_message, timoutSeconds);
        element.click();
        return  element;

    }

    public WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timoutSeconds){
        WebElement element = waitForElementPresent(by, error_message, timoutSeconds);
        element.sendKeys(value);
        return  element;

    }
    public void pressEnterKey() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    public WebElement waitForElementAndClear(By by, String error_message, long timoutSeconds){
        WebElement element = waitForElementPresent(by, error_message, timoutSeconds);
        element.clear();
        return  element;

    }
}
