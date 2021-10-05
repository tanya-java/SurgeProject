package ui;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class LoginPage extends BasePage{

    @FindBy(id = "login_name")
    public WebElement loginInput;

    @FindBy(id = "login_password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"login-validate\"]/div[2]/button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"login-wrapper\"]/div[1]/div[1]/div/strong")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String username, String password){
        log.info(String.format("You have logged in",username,password));
        loginInput.click();
        loginInput.sendKeys(username);
        passwordInput.click();
        passwordInput.sendKeys(password);
        loginButton.click();

        return new HomePage(driver);
    }

    public WebElement getErrorMessage(){
        return errorMessage;
    }
}
