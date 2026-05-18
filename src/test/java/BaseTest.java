import org.example.DriverManager;
import org.example.service.MainPageService;
import org.example.service.ModalPageService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected MainPageService mainPageService;

    @BeforeMethod
    public void beforeMethod() {
        mainPageService = new MainPageService();
        mainPageService.openPageAndAcceptCookie();
    }


    @AfterMethod
    public void afterMethod() {
        DriverManager.closeDriver();
    }
}
