import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class SettingsTest extends BaseTest {

    private static final String USERNAME = "termalickaya@mail.ru";
    private static final String PASSWORD = "Qweasd123#";
    private static final String LAST_NAME = "yermalitskaya";
    private static final String BIRTHDAY = "11/03/1997";
    private static final String WEIGHT = "60";
    private static final String CITY = "Minsk";
    private static final String POSTAL_CODE = "220006";

    @Test(testName = "positive")
    public void addSettings(){
        HomePage homePage = loginPage.login(USERNAME, PASSWORD);
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.addInfo(LAST_NAME,BIRTHDAY,WEIGHT,CITY,POSTAL_CODE);
        Assert.assertTrue(true,driver.findElement(By.xpath("//*[@id=\"EditProfile\"]/div/div[2]/p[1]"))
                .getText()
                .concat("tanya yermalitskaya"));
    }
}
