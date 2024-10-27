package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static AppiumDriver<MobileElement> driver;
    private static String platform;
    public static void setPlatform(String platformName) {
        platform = platformName;
    }


    public static AppiumDriver<MobileElement> getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }


    private static void initializeDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        try {
            switch (platform.toLowerCase()) {
                case "android":
                    setupAndroidCapabilities(capabilities);
                    driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                    break;

                case "ios":
                    setupIOSCapabilities(capabilities);
                    driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported platform: " + platform);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize Appium Driver.");
        }
    }


    private static void setupAndroidCapabilities(DesiredCapabilities capabilities) {
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("udid", "emulator-5554"); // Adjust if needed
        capabilities.setCapability("automationName", "UiAutomator2");
    }


    private static void setupIOSCapabilities(DesiredCapabilities capabilities) {
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("udid", "auto"); // Replace with specific UDID if needed
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("bundleId", "com.example.iosApp"); // Adjust the bundle ID
        capabilities.setCapability("deviceName", "iPhone Simulator");
        capabilities.setCapability("platformVersion", "15.2"); // Adjust as needed
    }


    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
