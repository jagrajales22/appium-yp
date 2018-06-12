package com.yellowpepper.automation_test.screen;


import com.yellowpepper.automation_test.util.BaseScreen;

public class MainScreen extends BaseScreen {

    private String registerButton = "com.yellowpepper.automation_test:id/registerButton";
    private String loginButton = "com.yellowpepper.automation_test:id/loginButton";


    public void clickRegisterButton() {
        click(registerButton);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

}
