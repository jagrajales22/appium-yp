package com.yellowpepper.automation_test.util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.*;
import java.net.URL;

public class BaseTest {

    private static final String APP_ACTIVITY = "com.yellowpepper.automation_test.MainActivity";
    private static final String APP_PACKAGE = "com.yellowpepper.automation_test";
    private static final String APP_VERSION = "app-debug-no-crash.apk";
    private static final String EMULATOR_NAME = "emulator-5554";
    private static final String LOCAL_HOST = "http://127.0.0.1:4723/wd/hub";
    private static final String OPERATIONAL_SYSTEM = "Android";
    private static final String OPERATIONAL_SYSTEM_VERSION = "7.1.1";
    public static AndroidDriver<AndroidElement> driver;
    private File appDir = new File(System.getProperty("user.home").concat("/app-dir"));


    @BeforeMethod
    public void setUp() throws Exception {
        File app = new File(appDir, APP_VERSION);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, EMULATOR_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, OPERATIONAL_SYSTEM);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, OPERATIONAL_SYSTEM_VERSION);
        capabilities.setCapability("avd", "Nexus_5X_API_25");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", APP_PACKAGE);
        capabilities.setCapability("appActivity", APP_ACTIVITY);
        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new AndroidDriver<>(new URL(LOCAL_HOST), capabilities);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
