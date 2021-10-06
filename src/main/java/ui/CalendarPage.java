package ui;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class CalendarPage extends BasePage{

    @FindBy(id = "QuickAddToggle")
    private WebElement quickAddButton;

    @FindBy(id = "WorkoutTime")
    private WebElement workoutTimeInput;

    @FindBy(id = "Name")
    private WebElement workOutNameInput;

    @FindBy(id = "Distance")
    private WebElement distanceInput;

    @FindBy(id = "Duration")
    private WebElement durationInput;

    @FindBy(id = "saveButton")
    private WebElement addWorkOutButton;

    @FindBy(id = "WorkoutDate")
    private WebElement dateInput;

    @FindBy(css = "div[class='fc-event-activity-title']")
    private WebElement activityContent;

    @FindBy(css = "div[class='alert alert-error']")
    private WebElement errorMessage;

    public CalendarPage addWorkout(String time, String name, String distance, String duration, String date){

        log.info(String.format("You have added a workout",time, name, distance,duration, date));
        quickAddButton.click();
        workoutTimeInput.click();
        workoutTimeInput.sendKeys(time);
        driver.findElement(By.id("ActivityType")).click();
        new Select(driver.findElement(By.id("ActivityType"))).selectByVisibleText("Walk");
        distanceInput.click();
        distanceInput.sendKeys(distance);
        durationInput.click();
        durationInput.sendKeys(duration);
        driver.findElement(By.id("DistType")).click();
        new Select(driver.findElement(By.id("DistType"))).selectByVisibleText("km");
        workOutNameInput.click();
        workOutNameInput.sendKeys(name);
        driver.findElement(By.id("HowFeel")).click();
        new Select(driver.findElement(By.id("HowFeel"))).selectByValue("1");
        driver.findElement(By.id("PerEffort")).click();
        new Select(driver.findElement(By.id("PerEffort"))).selectByIndex(4);
        dateInput.click();
        dateInput.clear();
        dateInput.sendKeys(date);
        dateInput.submit();
        addWorkOutButton.click();
        return new CalendarPage(driver);
    }

    public CalendarPage addWrongWorkout(String time, String name, String distance, String duration, String date){

        log.warn(String.format("You couldn't add a workout",time, name, distance,duration, date));
        quickAddButton.click();
        workoutTimeInput.click();
        workoutTimeInput.sendKeys(time);
        workoutTimeInput.submit();
        distanceInput.click();
        distanceInput.sendKeys(distance);
        durationInput.click();
        durationInput.sendKeys(duration);
        driver.findElement(By.id("DistType")).click();
        new Select(driver.findElement(By.id("DistType"))).selectByVisibleText("km");
        workOutNameInput.click();
        workOutNameInput.sendKeys(name);
        driver.findElement(By.id("HowFeel")).click();
        new Select(driver.findElement(By.id("HowFeel"))).selectByValue("1");
        driver.findElement(By.id("PerEffort")).click();
        new Select(driver.findElement(By.id("PerEffort"))).selectByIndex(4);
        dateInput.click();
        dateInput.clear();
        dateInput.sendKeys(date);
        dateInput.submit();
        addWorkOutButton.click();
        return new CalendarPage(driver);
    }

    public WebElement getActivityContent() {
        return activityContent;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public CalendarPage(WebDriver driver) {
        super(driver);
    }
}
