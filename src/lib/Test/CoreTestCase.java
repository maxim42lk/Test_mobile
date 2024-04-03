package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase extends TestCase {
        public AppiumDriver driver;
        public static String AppiumURL = "http://127.0.0.1:4723";

    @Override
        public void setUp() throws Exception{
            super.setUp();
            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("platformName", "android");
            capabilities.setCapability("appium:automationName", "uiautomator2");
            capabilities.setCapability("appPackage", "org.wikipedia");
            capabilities.setCapability("appActivity", ".main.MainActivity");
            capabilities.setCapability("platformVersion", "9.0");
            capabilities.setCapability("deviceName", "HUAWEI Y6 2019");
            capabilities.setCapability("app", "C:\\Users\\maxim\\Desktop\\lab_mobile_debug-main\\untitled\\apks\\org.wikipedia.apk");
            driver = new AndroidDriver(new URL(AppiumURL), capabilities);
        }

    @Override
        protected void tearDown() throws  Exception{
            driver.quit();
            super.tearDown();
        }
}
