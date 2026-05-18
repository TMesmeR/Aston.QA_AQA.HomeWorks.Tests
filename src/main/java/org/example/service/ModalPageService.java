package org.example.service;

import org.example.page.ModalPage;
import org.example.utils.LogoPayWrapperModalPage;

public class ModalPageService {
    private final ModalPage modalPage;
    public ModalPageService(ModalPage modalPage) {
        this.modalPage = modalPage;
    }

    public boolean getLogoPayWrapperIsDisplayed(LogoPayWrapperModalPage logoPayWrapper) {
        return modalPage.isLogoPresent(logoPayWrapper);
    }

    public String getPaymentAmount() {
        return modalPage.getPaymentAmountText();
    }

    public String getAmountOnButton() {
        return modalPage.getAmountOnButtonText();
    }

    public String getPhoneNumber() {
        return modalPage.getPhoneNumberText();
    }
    public boolean areAllLabelsDisplayed() {
        return modalPage.areAllLabelsDisplayed();
    }
}
