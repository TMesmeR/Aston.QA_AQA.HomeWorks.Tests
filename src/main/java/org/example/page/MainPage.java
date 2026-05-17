package org.example.page;

import org.example.utils.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage extends BasePage {
    @FindBy(xpath = "//a[text() = 'Принять все cookie']")
    private List<WebElement> cookieButton;
    @FindBy(xpath = "//div[text() = \"Вход\"]")
    private WebElement enterButton;


    public MainPage openPage(String url) {
        driver.get(url);
        return this;
    }


    public MainPage acceptCookieButton() {
        if (!cookieButton.isEmpty()) {
            cookieButton.getFirst().click();
            Waiter.waitElementToBeInvisible(cookieButton.getFirst());
        }
        return this;
    }

    public void clickEnterButton() {
        enterButton.click();
    }
}
