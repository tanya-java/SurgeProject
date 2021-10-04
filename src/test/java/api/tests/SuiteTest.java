package api.tests;

import api.models.Suite;
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
                .post("suite/ATT")
            .then()
                .log().all()
                .extract().asString();
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
                .delete("suite/ATT")
            .then()
                .log().all()
                .extract().asString();
        }
}
