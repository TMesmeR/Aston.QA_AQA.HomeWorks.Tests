package org.example.page;

import org.example.utils.LogoPayWrapperModalPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class ModalPage extends BasePage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @FindBy(xpath = "//span[@class=\"ng-star-inserted\"]")
    private WebElement paymentAmount;

    @FindBy(xpath = "//div[@class='pay-description__text']/span")
    private WebElement phoneNumberUser;

    @FindBy(xpath = "//button[@type='submit']/span")
    private WebElement submitButton;

    @FindBy(xpath = "//label[text() = \"Номер карты\"]")
    private WebElement cardNumber;

    @FindBy(xpath = "//label[text() = \"Срок действия\"]")
    private WebElement cardValidityPeriod;

    @FindBy(xpath = "//label[text() = \"CVC\"]")
    private WebElement cvc;

    @FindBy(xpath = "//label[text() =\"Имя и фамилия на карте\"]")
    private WebElement firstLastName;

    @FindBy(xpath = "//img[@src=\"assets/images/payment-icons/card-types/visa-system.svg\"]")
    private WebElement visaIcon;
    @FindBy(xpath = "//img[@src=\"assets/images/payment-icons/card-types/mastercard-system.svg\"]")
    private WebElement masterIcon;
    @FindBy(xpath = "//img[@src=\"assets/images/payment-icons/card-types/belkart-system.svg\"]")
    private WebElement belkartIcon;
    @FindBy(xpath = "//img[@src=\"assets/images/payment-icons/card-types/maestro-system.svg\"]")
    private WebElement maestroIcon;
    @FindBy(xpath = "//img[@src=\"assets/images/payment-icons/card-types/mir-system-ru.svg\"]")
    private WebElement mirIcon;


    public boolean isLogoPresent(LogoPayWrapperModalPage logoPayWrapper) {
        return switch (logoPayWrapper) {
            case VisaIcon -> {
                wait.until(ExpectedConditions.visibilityOf(visaIcon));
                yield visaIcon.isDisplayed();
            }
            case MasterIcon -> {
                wait.until(ExpectedConditions.visibilityOf(masterIcon));
                yield masterIcon.isDisplayed();
            }
            case BelkartIcon -> {
                wait.until(ExpectedConditions.visibilityOf(belkartIcon));
                yield belkartIcon.isDisplayed();
            }
            case MaestroIcon -> {
                wait.until(ExpectedConditions.visibilityOf(maestroIcon));
                yield maestroIcon.isDisplayed();
            }
            case MirIcon -> {
                wait.until(ExpectedConditions.visibilityOf(mirIcon));
                yield mirIcon.isDisplayed();
            }
        };
    }

    public String getPaymentAmountText() {
        wait.until(ExpectedConditions.visibilityOf(paymentAmount));
        return paymentAmount.getText();
    }

    public String getPhoneNumberText() {
        wait.until(ExpectedConditions.visibilityOf(phoneNumberUser));
        return phoneNumberUser.getText();
    }

    public String getAmountOnButtonText() {
        wait.until(ExpectedConditions.visibilityOf(phoneNumberUser));
        return submitButton.getText();
    }

    public boolean areAllLabelsDisplayed() {
        return cardNumber.isDisplayed() &&
                cardValidityPeriod.isDisplayed() &&
                cvc.isDisplayed() &&
                firstLastName.isDisplayed();
    }
}
