package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {
    @FindBy(xpath = "//input[@placeholder=\"Ник или e-mail\"]")
    WebElement emailInput;
    @FindBy(xpath = "//input[@placeholder=\"Пароль\"]")
    WebElement passwordInput;
    @FindBy(xpath = "//button")
    WebElement submitButton;
    @FindBy(xpath = "//div[contains(text(), \"Неверный\")]")
    WebElement errorMessage;

    public RegistrationPage inputEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public RegistrationPage inputPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public RegistrationPage submitButtonClick() {
        submitButton.click();
        return this;
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }


}
