package org.example.page;

import org.example.utils.LogoPayWrapper;
import org.example.utils.ServicesPayment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class MainPage extends BasePage {
    @FindBy(xpath = "//button[text() = 'Принять']")
    private List<WebElement> cookieButton;
    @FindBy(xpath = "//h2[contains(text(),'Онлайн')]")
    private WebElement headerPayWrapper;

    @FindBy(xpath = "//img[@alt='VISA']")
    private WebElement logoVisa;
    @FindBy(xpath = "//img[@alt='Verified By Visa']")
    private WebElement logoVerifiedVisa;
    @FindBy(xpath = "//img[@alt='MasterCard']")
    private WebElement logoMasterCard;
    @FindBy(xpath = "//img[@alt='MasterCard Secure Code']")
    private WebElement logoMastercardSecureCode;
    @FindBy(xpath = "//img[@alt='Белкарт']")
    private WebElement logoBelcard;
    @FindBy(xpath = "//a[text()='Подробнее о сервисе']")
    private WebElement linkService;
    @FindBy(xpath = "//input[@id=\"connection-phone\"]")
    private WebElement phoneNumber;
    @FindBy(xpath = "//*[@id=\"connection-sum\"]")
    private WebElement sumPayment;
    @FindBy(xpath = "//*[@id=\"pay-connection\"]/button")
    private WebElement senderButton;

    @FindBy(xpath = "//input[@id=\"internet-phone\"]")
    private WebElement subscriberNumber;

    @FindBy(xpath = "//input[@id=\"score-instalment\"]")
    private WebElement accountNumber;

    @FindBy(xpath = "//input[@id=\"score-arrears\"]")
    private WebElement accountNumberDebt;

    @FindBy(xpath = "//iframe[@class = 'payment-widget-iframe']")
    private WebElement paymentModal;

    public MainPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public MainPage acceptCookieButton() {
        if (!cookieButton.isEmpty()) {
            cookieButton.getFirst().click();
        }
        return this;
    }

    public String getHeaderPayWrapperText() {
        return headerPayWrapper.getText();
    }


    public boolean isLogoPresent(LogoPayWrapper logoPayWrapper) {
        return switch (logoPayWrapper) {
            case Visa -> logoVisa.isDisplayed();
            case VerifiedVisa -> logoVerifiedVisa.isDisplayed();
            case MasterCard -> logoMasterCard.isDisplayed();
            case MastercardSecureCode -> logoMastercardSecureCode.isDisplayed();
            case Belcard -> logoBelcard.isDisplayed();
        };
    }

    public String clickLinkService() {
        linkService.click();
        var url = driver.getCurrentUrl();
        driver.switchTo().defaultContent();
        return url;
    }

    public MainPage setPhoneNumber(String phoneNumber) {
        this.phoneNumber.sendKeys(phoneNumber);
        return this;
    }

    public MainPage setSumPayment(String sumPayment) {
        this.sumPayment.sendKeys(sumPayment);
        return this;
    }

    public void clickSenderButton() {
        senderButton.click();
    }

    public List<String> checkPlaceholders(ServicesPayment servicesPayment) {
            return switch (servicesPayment){
                case homeInternetServices -> checkPlaceholdersByWebElement(subscriberNumber);
                case communicationServices -> checkPlaceholdersByWebElement(phoneNumber);
                case installmentPlanServices -> checkPlaceholdersByWebElement(accountNumber);
                case debtServices -> checkPlaceholdersByWebElement(accountNumberDebt);
            };
    }

    public ModalPage getModalPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentModal));
        return new ModalPage();
    }
    private List<String> checkPlaceholdersByWebElement(WebElement element){
        List<String> placeholders = new ArrayList<>();
        placeholders.add(element.getAttribute("placeholder"));
        placeholders.add(sumPayment.getAttribute("placeholder"));
        return placeholders;
    }
}
