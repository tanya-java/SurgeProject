import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
