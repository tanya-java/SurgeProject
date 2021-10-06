package api.tests;

import api.models.Suite;
import api.models.responses.SuiteResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SuiteTest {
    public static final String TOKEN = "be7417c974ae731b98f135afe3af952c6156879b";

   @Test(priority = 1, groups = "Group")
    public void addSuiteTest(){
        Suite suite = Suite.builder()
                .title("Password")
                .build();

        SuiteResponse suiteResponse = given().baseUri("https://api.qase.io/v1/")
                .header("Token",TOKEN)
            .when()
                .body(suite)
                .post("suite/AYT")
            .then()
                .log().all()
                .extract().as(SuiteResponse.class);
       Assert.assertNotNull(suiteResponse);
    }

    @Test(priority = 2, groups = "Group")
    public void changeSuiteTest(){
        Suite suite = Suite.builder()
                .title("New password")
                .build();

        SuiteResponse suiteResponse = given().baseUri("https://api.qase.io/v1/")
                .header("Token",TOKEN)
            .when()
                .body(suite)
                .patch("suite/AYT/8")
            .then()
                .log().all()
                .extract().as(SuiteResponse.class);
        Assert.assertNotNull(suiteResponse);
    }

    @Test(priority = 3, groups = "Group")
    public void deleteSuiteTest(){
        Suite suite = Suite.builder()
                .title("New password")
                .build();

        SuiteResponse suiteResponse = given().baseUri("https://api.qase.io/v1/")
                .header("Token",TOKEN)
            .when()
                .body(suite)
                .delete("suite/AYT/8")
            .then()
                .log().all()
                .extract().as(SuiteResponse.class);
        Assert.assertNotNull(suiteResponse);
        }
}
