package org.example.service;

import org.example.page.MainPage;
import org.example.utils.Constants;
import org.example.utils.LogoPayWrapper;
import org.example.utils.ServicesPayment;

import java.util.List;

public class MainPageService {
    private final MainPage mainPage;

    public MainPageService() {
        this.mainPage = new MainPage();
    }

    public MainPageService openPageAndAcceptCookie() {
        mainPage
                .openPage(Constants.MAIN_PAGE_URL)
                .acceptCookieButton();
        return this;
    }

    public String getHeaderPayWrapperText() {
        return mainPage.getHeaderPayWrapperText();
    }

    public boolean getLogoPayWrapperIsDisplayed(LogoPayWrapper logoPayWrapper) {
        return mainPage.isLogoPresent(logoPayWrapper);
    }

    public String getUrlLinkService() {
        return mainPage.clickLinkService();
    }

    //не используется, просто для красоты
    public MainPageService setPhoneNumber(String phoneNumber) {
        mainPage.setPhoneNumber(phoneNumber);
        return this;
    }

    //не используется, просто для красоты
    public MainPageService setSumPayment(String sumPayment) {
        mainPage.setSumPayment(sumPayment);
        return this;
    }

    public MainPageService setPhoneAndSumPayment(String phone, String sumPayment) {
        mainPage
                .setPhoneNumber(phone)
                .setSumPayment(sumPayment);
        return this;
    }

    public ModalPageService openModalPage() {
        mainPage
                .clickSenderButton();
        var modalPage = mainPage.getModalPage();
        return new ModalPageService(modalPage);
    }

    public List<String> getPlaceholders(ServicesPayment  servicesPayment) {
      return   mainPage.checkPlaceholders(servicesPayment);
    }
}
