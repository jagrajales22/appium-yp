package com.yellowpepper.automation_test.screen;


import com.yellowpepper.automation_test.util.BaseScreen;

public class LoginScreen extends BaseScreen {

    private String usernameTextFieldId = "com.yellowpepper.automation_test:id/usernameTextField";
    private String passwordTextFieldId = "com.yellowpepper.automation_test:id/passwordTextField";
    private String loginButtonId = "com.yellowpepper.automation_test:id/loginButton";


    public void loginUser(String username, String password) {
        typeUsername(username);
        typePassword(password);
        clickLoginButton();
    }

    private void typeUsername(String username) {
        type(usernameTextFieldId, username);
    }

    private void typePassword(String password) {
        type(passwordTextFieldId, password);
    }

    private void clickLoginButton() {
        click(loginButtonId);
    }

}
