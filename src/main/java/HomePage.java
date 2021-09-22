import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(id = "QuickAddToggle")
    private WebElement quickAddButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getQuickAddButton(){
        return quickAddButton;
    }
}
