import org.testng.Assert;
import org.testng.annotations.Test;

public class CalendarTest extends BaseTest {

    private static final String USERNAME = "termalickaya@mail.ru";
    private static final String PASSWORD = "Qweasd123#";
    private static final String TIME = "07:00";
    private static final String NAME = "First workout";
    private static final String DISTANCE = "10";
    private static final String DURATION = "01:00:00";
    private static final String DATE = "9/21/2021";


    @Test(testName = "positive")
    public void addWorkoutTest(){
        HomePage homePage = loginPage.login(USERNAME,PASSWORD);
        CalendarPage calendarPage = new CalendarPage(driver);
        calendarPage.addWorkout(TIME,NAME,DISTANCE,DURATION,DATE);
        Assert.assertTrue(calendarPage.getActivityContent().isDisplayed());
    }

    @Test(testName = "negative")
    public void addWrongWorkoutTest(){
        HomePage homePage = loginPage.login(USERNAME,PASSWORD);
        CalendarPage calendarPage = new CalendarPage(driver);
        calendarPage.addWorkout(TIME,NAME,DISTANCE,DURATION,DATE);
        Assert.assertTrue(calendarPage.getErrorMessage().isDisplayed());
    }
}
