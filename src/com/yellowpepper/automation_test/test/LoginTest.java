package com.yellowpepper.automation_test.test;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.yellowpepper.automation_test.util.BaseTest;
import com.yellowpepper.automation_test.util.BaseScreen;
import com.yellowpepper.automation_test.screen.MainScreen;
import com.yellowpepper.automation_test.screen.RegisterScreen;
import com.yellowpepper.automation_test.screen.LoginScreen;


public class LoginTest extends BaseTest {

    BaseScreen baseScreen;
    MainScreen mainScreen;
    RegisterScreen registerScreen;
    LoginScreen loginScreen;

    private String successfulRegisterName = "John Doe";
    private String successfulRegisterUsernameRoot = "JohnDoe";
    private String successfulRegisterUsername;
    private String successfulRegisterPassword = "123456";

    @BeforeTest
    public void setup() {
        baseScreen = new BaseScreen();
        mainScreen = new MainScreen();
        registerScreen = new RegisterScreen();
        loginScreen = new LoginScreen();
    }

    @BeforeMethod
    public void registerUser() {
        mainScreen.clickRegisterButton();
        successfulRegisterUsername = registerScreen.usernameRandomGeneration(successfulRegisterUsernameRoot);
        registerScreen.registerUser(successfulRegisterName, successfulRegisterUsername, successfulRegisterPassword);
        loginScreen.clickAlertOkButton();
    }

    @Test
    public void successfulLogin() {
        loginScreen.loginUser(successfulRegisterUsername, successfulRegisterPassword);

        loginScreen.assertAlertContent("Success", "Welcome " + successfulRegisterName);
        loginScreen.clickBackButton();
    }

    @Test
    public void wrongPasswordError() {
        loginScreen.loginUser(successfulRegisterUsername, "@WRONG");

        loginScreen.assertAlertContent("Error", "Invalid username/password.");
        loginScreen.clickBackButton();
    }

    @Test
    public void wrongUsernameError() {
        loginScreen.loginUser("@WRONG", successfulRegisterPassword);

        loginScreen.assertAlertContent("Error", "Invalid username/password.");
        loginScreen.clickBackButton();
    }

    @Test
    public void blankUsernameError() {
        loginScreen.loginUser("", successfulRegisterPassword);

        loginScreen.assertAlertContent("Error", "username is required.");
        loginScreen.clickBackButton();
    }

    @Test
    public void blankPasswordError() {
        loginScreen.loginUser(successfulRegisterUsername, "");

        loginScreen.assertAlertContent("Error", "password is required.");
        loginScreen.clickBackButton();
    }
}
