package org.example.service;

import io.qameta.allure.Step;
import org.example.page.MainPage;
import org.example.page.RegistrationPage;
import org.example.utils.Constants;

import static org.example.utils.Constants.MAIN_PAGE_URL;

public class MainPageService {
    private final MainPage mainPage;
    public MainPageService() {
        mainPage = new MainPage();
    }

    @Step("Open page and accept cookie")
    public MainPageService openPageAdAcceptCookie(){
        mainPage
                .openPage(MAIN_PAGE_URL)
                .acceptCookieButton();
        return this;
    }

    @Step("Click Button")
    public RegistrationPageServices clickButtonEnter(){
        mainPage.clickEnterButton();
        return new RegistrationPageServices();
    }
}
