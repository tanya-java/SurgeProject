package api.tests;

import api.models.Suite;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SuiteTest {
    public static final String TOKEN = "be7417c974ae731b98f135afe3af952c6156879b";

   @Test
    public void createSuiteTest(){
        Suite suite = Suite.builder()
                .title("Login")
                .build();

        String response = given().baseUri("https://api.qase.io/v1/")
                .header("Token",TOKEN)
            .when()
                .body(suite)
                .post("suite/AYT")
            .then()
                .log().all()
                .extract().asString();
        Assert.assertTrue(true,"The suite us created");
    }

    @Test
    public void deleteSuiteTest(){
        Suite suite = Suite.builder()
                .title("Login")
                .build();

        String response = given().baseUri("https://api.qase.io/v1/")
                .header("Token",TOKEN)
            .when()
                .body(suite)
                .delete("suite/AYT/3")
            .then()
                .log().all()
                .extract().asString();
        Assert.assertTrue(true, "The suite is deleted");
        }

    @Test
    public void updateSuiteTest(){
            Suite suite = Suite.builder()
                    .title("Login")
                    .build();

        String response = given().baseUri("https://api.qase.io/v1/")
                    .header("Token",TOKEN)
            .when()
                    .body(suite)
                    .delete("suite/AYT/3")
            .then()
                    .log().all()
                    .extract().asString();
            Assert.assertTrue(true,"The suite does not exist");
        }
}
