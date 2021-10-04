package api.tests;

import api.models.Project;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProjectTests {

    public static final String TOKEN = "be7417c974ae731b98f135afe3af952c6156879b";

    @Test
    public void createProjectTest(){
        Project project = Project.builder()
                .title("AQA_TT").code("ATT").description("Diploma Project #2").access("all")
                .build();

        String response = given().baseUri("https://api.qase.io/v1/")
                .header("Token",TOKEN)
            .when()
                .body(project)
                .post("project")
            .then()
                .log().all()
                .extract().asString();
    }

    @Test
    public void getAllProjects(){
        Project project = Project.builder()
                .limit(100)
                .offset(0)
                .build();

        String response = given().baseUri("https://api.qase.io/v1/")
                .header("Token",TOKEN)
            .when()
                .body(project)
                .get("project")
            .then()
                .log().all()
                .extract().asString();
    }
}
