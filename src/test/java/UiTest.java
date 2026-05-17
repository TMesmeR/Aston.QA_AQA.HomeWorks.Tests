import org.example.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UiTest {
    final By COOKIE_BUTTON = By.xpath("//button[text() = 'Принять']");
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setDriver() {
        driver = DriverManager.getDriver();
        driver.get("https://www.mts.by/");
        driver.findElement(COOKIE_BUTTON).click();
    }

    @Test
    public void checkOnlineRecharge(){
        final By FIND_BLOCK_BY_TEXT = By.xpath("//h2[contains(text(),'Онлайн')]");
        final String EXPECTED_TEXT = "Онлайн пополнение\nбез комиссии";
        Assert.assertEquals(driver.findElement(FIND_BLOCK_BY_TEXT).getText(), EXPECTED_TEXT);
    }

    @Test
    public void verifyPaymentSystemLogos(){
        final By LOGO_VISA = By.xpath("//img[@alt='VISA']");
        final By LOGO_VERIFIED_BY_VISA = By.xpath("//img[@alt='Verified By Visa']");
        final By LOGO_MASTERCARD = By.xpath("//img[@alt='MasterCard']");
        final By LOGO_MASTERCARD_SECURE_CODE = By.xpath("//img[@alt='MasterCard Secure Code']");
        final By LOGO_BELCARD = By.xpath("//img[@alt='Белкарт']");

        Assert.assertTrue(driver.findElement(LOGO_VISA).isDisplayed(), "Не отображается лого Visa");
        Assert.assertTrue(driver.findElement(LOGO_VERIFIED_BY_VISA).isDisplayed(), "Не отображается лого Verified By Visa");
        Assert.assertTrue(driver.findElement(LOGO_MASTERCARD).isDisplayed(), "Не отображается лого MasterCard");
        Assert.assertTrue(driver.findElement(LOGO_MASTERCARD_SECURE_CODE).isDisplayed(), "Не отображается лого MasterCard Secure Code");
        Assert.assertTrue(driver.findElement(LOGO_BELCARD).isDisplayed(), "Не отображается лого Белкарт");
    }

    @Test
    public void verifyServiceLink(){
        final By LINK_SERVICE = By.xpath("//a[text()='Подробнее о сервисе']");
        driver.findElement(LINK_SERVICE).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("poryadok-oplaty-i-bezopasnost-internet-platezhey"),"Нас кинуло куда-то не туда товарищ");
    }

    @Test
    public void verifyPaymentFormAndContinueButton(){
        final By PHONE_NUMBER = By.xpath("//input[@placeholder='Номер телефона']");
        final By SUM_PAYMENT = By.xpath("//*[@id=\"connection-sum\"]");
        final By SENDER_BTN = By.xpath("//*[@id=\"pay-connection\"]/button");
        final String TEST_SUM = "10";
        final String TEST_PHONE = "297777777";

        driver.findElement(PHONE_NUMBER).sendKeys(TEST_PHONE);
        driver.findElement(SUM_PAYMENT).sendKeys(TEST_SUM);
        driver.findElement(SENDER_BTN).click();
        System.out.println("Значения приняты, кнопка нажата, дальше появляется модальное окно");
    }

   @AfterMethod
    public void closeDriver() {
        DriverManager.closeDriver();
    }
}
