package ui;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class SettingsPage extends BasePage{

    @FindBy(xpath = "/html/body/div[1]/header/div/div/div[3]/div/div/div/ul/li[1]/a")
    private WebElement settingsButton;

    @FindBy(css = "span[class='dropdown-toggle']")
    private WebElement editProfileButton;

    @FindBy(id = "female")
    private WebElement genderInput;

    @FindBy(name = "BDay")
    private WebElement birthdayInput;

    @FindBy(name = "Weight")
    private WebElement weightInput;

    @FindBy(id = "optionsRadios4")
    private WebElement weightOptionsInput;

    @FindBy(id = "City")
    private WebElement cityInput;

    @FindBy(id = "Zip")
    private WebElement postalCodeInput;

    @FindBy(id ="saveButtonProfile")
    private WebElement saveButton;

    @FindBy(xpath = "/html/body/div[16]/div[1]/table/tbody/tr[2]/td[2]")
    private WebElement birthdayConfirm;

    @FindBy(id = "lname")
    private WebElement lastNameInput;

    @FindBy(xpath = "//*[@parentId=\"EditProfile\"]/div/div[2]/p[1]/text()")
    private WebElement lastname;

    public SettingsPage addInfo(String lastName, String birthday, String weight, String city, String postalCode){

        log.info(String.format("Your settings have been added",lastName,birthday,weight,city,postalCode));
        settingsButton.click();
        editProfileButton.click();
        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        genderInput.click();
        birthdayInput.click();
        birthdayInput.sendKeys(birthday);
        birthdayConfirm.click();
        weightInput.click();
        weightInput.sendKeys(weight);
        weightOptionsInput.click();
        driver.findElement(By.id("Country")).click();
        new Select(driver.findElement(By.id("Country"))).selectByVisibleText("Belarus");
        driver.findElement(By.id("Region")).click();
        new Select(driver.findElement(By.id("Region"))).selectByVisibleText("Horad Minsk");
        cityInput.click();
        cityInput.sendKeys(city);
        postalCodeInput.click();
        postalCodeInput.sendKeys(postalCode);
        saveButton.click();
        return new SettingsPage(driver);
    }

    public WebElement getLastName(){
        return lastname;
    }

    public SettingsPage(WebDriver driver) {
        super(driver);
    }
}
