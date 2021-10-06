package api.tests;

import api.models.Project;
import api.models.responses.ProjectResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProjectTests {

    public static final String TOKEN = "be7417c974ae731b98f135afe3af952c6156879b";

    @Test
    public void createProjectTest(){
        Project project = Project.builder()
                .title("AQA_YTU").code("YTU").description("Diploma Project #2").access("all")
                .build();

        ProjectResponse projectResponse = given().baseUri("https://api.qase.io/v1/")
                .header("Token",TOKEN)
            .when()
                .body(project)
                .post("project")
            .then()
                .log().all()
                .extract().as(ProjectResponse.class);
    Assert.assertEquals(projectResponse.getResult().getCode(), project.getCode());
    }

//    @Test
//    public void getSpecificProject(){
//        Project project = Project.builder()
//                .code("YTU")
//                .build();
//
//        ProjectResponse projectResponse = given().baseUri("https://api.qase.io/v1/")
//                .header("Token",TOKEN)
//            .when()
//                .body(project)
//                .get("project/YTU")
//            .then()
//                .log().all()
//                .extract().as(ProjectResponse.class);
//        Assert.assertEquals(projectResponse.getResult().getCode(), project.getCode());
//    }
}
