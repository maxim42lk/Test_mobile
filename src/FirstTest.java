import io.appium.java_client.AppiumDriver;
import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class FirstTest {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("deviceName", "HUAWEI Y6 2019");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appPackage", "org.wikipedia");
        desiredCapabilities.setCapability("appActivity", ".main.MainActivity");
        desiredCapabilities.setCapability("app", "C:\\Users\\maxim\\Desktop\\lab_mobile_debug-main\\untitled\\apks\\org.wikipedia.apk");

        URL remoteUrl = new URL("http://localhost:4723");

        AppiumDriver<MobileElement> driver = new AndroidDriver<>(remoteUrl, desiredCapabilities);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        MobileElement deleteList2 = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Википедия\"]"));
        deleteList2.click();

        // Поиск по статье "Хоббит, или Туда и обратно"
        MobileElement searchBox = driver.findElement(By.id("org.wikipedia:id/search_container"));
        searchBox.click();
        MobileElement searchBox2 = driver.findElement(By.id("org.wikipedia:id/search_src_text"));
        searchBox2.sendKeys("Хоббит, или Туда и обратно");

        // Нажать на статью и добавить в список для чтения
        MobileElement article = driver.findElement(By.id("org.wikipedia:id/page_list_item_title"));
        article.click();

        MobileElement overflowMenu = driver.findElement(By.id("org.wikipedia:id/page_save"));
        overflowMenu.click();

        MobileElement addToList = driver.findElement(By.id("org.wikipedia:id/snackbar_action"));
        addToList.click();
        // Ввод названия
        MobileElement searchBox3 = driver.findElement(By.id("org.wikipedia:id/text_input"));
        searchBox3.sendKeys("Хоббит");

        // Подтвердить добавление в список
        MobileElement okButton = driver.findElement(By.id("android:id/button1"));
        okButton.click();

        // Перейти в список для чтения
        driver.findElement(By.id("org.wikipedia:id/snackbar_action")).click();

        // Удалить список для чтения
        MobileElement overflowMenu2 = driver.findElement(By.id("org.wikipedia:id/item_overflow_menu"));
        overflowMenu2.click();


        MobileElement deleteList = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"org.wikipedia:id/title\" and @text=\"Удалить список\"]"));
        deleteList.click();

        MobileElement okButton2 = driver.findElement(By.id("android:id/button1"));
        okButton2.click();
        // Удостовериться, что раздел "Хоббит" отсутствует в списке
        boolean isHobbitRemoved = driver.findElements(By.id("org.wikipedia:id/empty_container")).stream()
                .noneMatch(element -> element.getText().equals("Хоббит"));

        System.out.println("Удален ли раздел Хоббит: " + isHobbitRemoved);

        // Закрываем драйвер
        driver.quit();
    }
}


