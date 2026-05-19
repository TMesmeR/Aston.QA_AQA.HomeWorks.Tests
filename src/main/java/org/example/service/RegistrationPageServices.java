package org.example.service;

import io.qameta.allure.Step;
import org.example.page.RegistrationPage;

public class RegistrationPageServices {
    private final RegistrationPage registrationPage;

    public RegistrationPageServices() {
        this.registrationPage = new RegistrationPage();
    }

    @Step("Input incorrect values")
    public String inputIncorrectValues(String email, String password) {
        return registrationPage.inputEmail(email)
                .inputPassword(password)
                .submitButtonClick()
                .getErrorMessage();
    }
}
