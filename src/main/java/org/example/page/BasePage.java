package org.example.page;

import org.example.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver = DriverManager.getDriver();

    protected BasePage() {
        PageFactory.initElements(driver, this);
    }
}
