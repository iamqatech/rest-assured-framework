package tests;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utilities.Helper;
import utilities.SchemaPath;

import static io.restassured.RestAssured.given;

public class Users {

    public String baseUrl = Helper.getProperty("baseUrl");

    @Test(priority = 2)
    public void getUser() {
        given().baseUri(baseUrl)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .when().get("/Users/1")
                .then().statusCode(HttpStatus.SC_OK)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(SchemaPath.USER_SCHEMA.getPath()));
    }

    @Test(priority = 1)
    public void getUsers() {
        given().baseUri(baseUrl)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .when().get("/Users")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(SchemaPath.USERS_SCHEMA.getPath()));


    }

}
