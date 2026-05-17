import jdk.jfr.Description;
import org.example.DriverManager;
import org.example.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

import static org.example.utils.Constants.ERROR_INCORRECT_REGISTRATION;

public class UiTestLesson extends BaseTest {
    @DataProvider(name = "incorrect values for test")
    public Object[][] incorrectValues() {
        return new Object[][]{
                {"111111", "2222222"},
                {"asd", "ывывыв"}
        };
    }

    @Test(testName = "Test incorrect values", dataProvider = "incorrect values for test")
    @Description("Verify login user")
    public void verifyRegistry(String email, String password) {
        var actualResult = mainPageService
                .openPageAdAcceptCookie()
                .clickButtonEnter()
                .inputIncorrectValues(email, password);
        Assert.assertEquals(actualResult, ERROR_INCORRECT_REGISTRATION, "test failed, message is not correct!");
    }
}
