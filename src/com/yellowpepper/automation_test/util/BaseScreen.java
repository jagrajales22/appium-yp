package com.yellowpepper.automation_test.util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertEquals;

public class BaseScreen extends BaseTest {

    private String alertTitleId = "android:id/alertTitle";
    private String alertMessageId = "android:id/message";
    private String alertOkButtonId = "android:id/button1";
    private String backButtonId = "com.yellowpepper.automation_test:id/backButton";


    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    public void click(String id) {
        waitForPresence(driver, 30, id);
        withId(id).click();
    }

    public void type(String id, String string) {
        waitForPresence(driver, 30, id);
        withId(id).setValue(string);
    }

    public AndroidElement withId(String id) {
        return driver.findElementById(id);
    }

    public String getAlertTitle() {
        return withId(alertTitleId).getText();
    }

    public String getAlertMessage() {
        return withId(alertMessageId).getText();
    }

    public void clickAlertOkButton() {
        click(alertOkButtonId);
    }

    public void clickBackButton() {
        click(backButtonId);
    }

    public void assertAlertContent(String title, String message) {
        waitForPresence(driver, 30, alertOkButtonId);
        assertEquals(getAlertTitle(), title);
        assertEquals(getAlertMessage(), message);
        clickAlertOkButton();
    }

    public String usernameRandomGeneration(String usernameRoot) {
        return usernameRoot + RandomStringUtils.randomAlphabetic(12);
    }

    private void explicitWait(Long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void waitForPresence(AndroidDriver driver, int timeLimitInSeconds, String id) {
        explicitWait(1000L);
        WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }
}
