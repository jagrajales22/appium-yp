package com.yellowpepper.automation_test.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.yellowpepper.automation_test.util.BaseTest;
import com.yellowpepper.automation_test.util.BaseScreen;
import com.yellowpepper.automation_test.screen.MainScreen;
import com.yellowpepper.automation_test.screen.RegisterScreen;
import com.yellowpepper.automation_test.screen.LoginScreen;


public class RegisterTest extends BaseTest {

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

    @Test
    public void successfulRegisterFullName() {
        mainScreen.clickRegisterButton();

        successfulRegisterUsername = registerScreen.usernameRandomGeneration(successfulRegisterUsernameRoot);
        registerScreen.registerUser(successfulRegisterName, successfulRegisterUsername, successfulRegisterPassword);

        registerScreen.assertAlertContent("Success", "Register successful, please login");
        registerScreen.clickBackButton();
    }

    @Test
    public void successfulRegisterNoName() {
        mainScreen.clickRegisterButton();

        successfulRegisterUsername = registerScreen.usernameRandomGeneration(successfulRegisterUsernameRoot);
        registerScreen.registerUser("", successfulRegisterUsername, successfulRegisterPassword);

        registerScreen.assertAlertContent("Success", "Register successful, please login");
        registerScreen.clickBackButton();
    }

    @Test
    public void alreadyRegisteredUserError() {
        mainScreen.clickRegisterButton();
        successfulRegisterUsername = registerScreen.usernameRandomGeneration(successfulRegisterUsernameRoot);
        registerScreen.registerUser(successfulRegisterName, successfulRegisterUsername, successfulRegisterPassword);

        loginScreen.clickAlertOkButton();
        loginScreen.clickBackButton();
        mainScreen.clickRegisterButton();
        registerScreen.registerUser(successfulRegisterName, successfulRegisterUsername, successfulRegisterPassword);

        registerScreen.assertAlertContent("Error", "Account already exists for this username.");
        registerScreen.clickBackButton();
    }

    @Test
    public void blankUsernameError() {
        mainScreen.clickRegisterButton();

        registerScreen.registerUser(successfulRegisterName, "", successfulRegisterPassword);

        registerScreen.assertAlertContent(
                "Error",
                "java.lang.IllegalArgumentException: Username cannot be missing or blank"
        );
        registerScreen.clickBackButton();
    }

    @Test
    public void blankPasswordError() {
        mainScreen.clickRegisterButton();

        successfulRegisterUsername = registerScreen.usernameRandomGeneration(successfulRegisterUsernameRoot);
        registerScreen.registerUser(successfulRegisterName, successfulRegisterUsername, "");

        registerScreen.assertAlertContent(
                "Error",
                "java.lang.IllegalArgumentException: Password cannot be missing or blank"
        );
        registerScreen.clickBackButton();
    }
}
