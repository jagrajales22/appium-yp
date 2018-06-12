package com.yellowpepper.automation_test.screen;


import com.yellowpepper.automation_test.util.BaseScreen;

public class RegisterScreen extends BaseScreen {

    private String nameTextFieldId = "com.yellowpepper.automation_test:id/nameTextField";
    private String usernameTextFieldId = "com.yellowpepper.automation_test:id/usernameTextField";
    private String passwordTextFieldId = "com.yellowpepper.automation_test:id/passwordTextField";
    private String registerButtonId = "com.yellowpepper.automation_test:id/registerButton";


    public void registerUser(String name, String username, String password) {
        typeName(name);
        typeUsername(username);
        typePassword(password);
        clickRegisterButton();
    }

    private void typeName(String name) {
        type(nameTextFieldId, name);
    }

    private void typeUsername(String username) {
        type(usernameTextFieldId, username);
    }

    private void typePassword(String password) {
        type(passwordTextFieldId, password);
    }

    private void clickRegisterButton() {
        click(registerButtonId);
    }
}
