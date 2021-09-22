import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    private static final String USERNAME = "termalickaya@mail.ru";
    private static final String PASSWORD = "Qweasd123#";
    private static final String WRONG_USERNAME = "termalitskaya@mail.ru";
    private static final String WRONG_PASSWORD = "Qweasd123";

    @Test(testName = "positive")
    public void loginTest(){
        HomePage homePage = loginPage.login(USERNAME,PASSWORD);
        Assert.assertTrue(homePage.getQuickAddButton().isDisplayed());
    }

    @Test(testName = "negative")
    public void wrongLoginTest(){
        HomePage homePage = loginPage.login(WRONG_USERNAME,WRONG_PASSWORD);
        Assert.assertTrue(loginPage.getErrorMessage().isDisplayed());
    }
}
