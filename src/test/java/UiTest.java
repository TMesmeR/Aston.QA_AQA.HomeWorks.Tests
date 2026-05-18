
import org.example.service.ModalPageService;
import org.example.utils.Constants;
import org.example.utils.LogoPayWrapper;
import org.example.utils.LogoPayWrapperModalPage;
import org.example.utils.ServicesPayment;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class UiTest extends BaseTest {

    ModalPageService modalPageService;
    @Test
    public void checkOnlineRecharge(){
        Assert.assertEquals(mainPageService.getHeaderPayWrapperText(), Constants.EXPECTED_TEX_MTS);
    }

    @Test
    public void verifyPaymentSystemLogos(){
        Assert.assertTrue(mainPageService.getLogoPayWrapperIsDisplayed(LogoPayWrapper.Visa), "Не отображается лого Visa");
        Assert.assertTrue(mainPageService.getLogoPayWrapperIsDisplayed(LogoPayWrapper.VerifiedVisa), "Не отображается лого Verified By Visa");
        Assert.assertTrue(mainPageService.getLogoPayWrapperIsDisplayed(LogoPayWrapper.MasterCard), "Не отображается лого MasterCard");
        Assert.assertTrue(mainPageService.getLogoPayWrapperIsDisplayed(LogoPayWrapper.MastercardSecureCode), "Не отображается лого MasterCard Secure Code");
        Assert.assertTrue(mainPageService.getLogoPayWrapperIsDisplayed(LogoPayWrapper.Belcard), "Не отображается лого Белкарт");
    }


    @Test
    public void verifyServiceLink(){
        Assert.assertTrue(mainPageService.getUrlLinkService().contains("poryadok-oplaty-i-bezopasnost-internet-platezhey"),"Нас кинуло куда-то не туда товарищ");
    }


    @Test
    public void verifyPaymentFormAndContinueWithModalPage() {
        final String TEST_SUM = "10";
        final String TEST_PHONE = "297777777";

        modalPageService = mainPageService.setPhoneAndSumPayment(TEST_PHONE, TEST_SUM)
                .openModalPage();

        //Проверка корректности суммы (в тексте и на кнопке)
        String amountText = modalPageService.getPaymentAmount();
        String amountOnButton = modalPageService.getAmountOnButton();
        Assert.assertTrue(amountText.contains(TEST_SUM), "Сумма в описании не совпадает");
        Assert.assertTrue(amountOnButton.contains(TEST_SUM), "Сумма на кнопке не совпадает");
        // Проверка номера телефона
        String phoneFromModal = modalPageService.getPhoneNumber();
        Assert.assertTrue(phoneFromModal.contains(TEST_PHONE), "Номер телефона не совпадает");
        // Проверка надписей в незаполненных полях (лейблы)
        Assert.assertTrue(modalPageService.areAllLabelsDisplayed(), "Не все лейблы полей отображаются");
        // Проверка иконок платёжных систем
        Assert.assertTrue(modalPageService.getLogoPayWrapperIsDisplayed(LogoPayWrapperModalPage.VisaIcon), "Не отображается Виза");
        Assert.assertTrue(modalPageService.getLogoPayWrapperIsDisplayed(LogoPayWrapperModalPage.MasterIcon), "Не отображается Мастеркарт");
        Assert.assertTrue(modalPageService.getLogoPayWrapperIsDisplayed(LogoPayWrapperModalPage.BelkartIcon), "Не отображается Белкарт");
        Assert.assertTrue(modalPageService.getLogoPayWrapperIsDisplayed(LogoPayWrapperModalPage.MaestroIcon), "Не отображается Маэстро");
        Assert.assertTrue(modalPageService.getLogoPayWrapperIsDisplayed(LogoPayWrapperModalPage.MirIcon), "Не отображается Мир");


    }

    @Test
    public void placeholdersCommunicationServices(){
       List<String> placeholders = mainPageService.getPlaceholders(ServicesPayment.communicationServices);
       Assert.assertEquals(placeholders.get(0), "Номер телефона");
       Assert.assertEquals(placeholders.get(1), "Сумма");
    }

    @Test
    public void placeholdersHomeInternetServices(){
        List<String> placeholders = mainPageService.getPlaceholders(ServicesPayment.homeInternetServices);
        Assert.assertEquals(placeholders.get(0), "Номер абонента");
        Assert.assertEquals(placeholders.get(1), "Сумма");
    }
    @Test
    public void placeholdersInstallmentPlanServices(){
        List<String> placeholders = mainPageService.getPlaceholders(ServicesPayment.installmentPlanServices);
        Assert.assertEquals(placeholders.get(0), "Номер счета на 44");
        Assert.assertEquals(placeholders.get(1), "Сумма");
    }

    @Test
    public void placeholdersDebtServices(){
        List<String> placeholders = mainPageService.getPlaceholders(ServicesPayment.debtServices);
        Assert.assertEquals(placeholders.get(0), "Номер счета на 2073");
        Assert.assertEquals(placeholders.get(1), "Сумма");
    }
}
