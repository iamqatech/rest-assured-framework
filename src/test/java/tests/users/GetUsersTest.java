package tests.users;

import api.users.UsersApi;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.AllureManager;
import utilities.SchemaPath;

public class GetUsersTest {

    public UsersApi users;

    @BeforeClass
    public void initializeTest() {

        users = new UsersApi();

    }

    @Test(priority = 2)
    public void verifyGetUserById() {
        Response res = users.getUser(1);
        AllureManager.attachResponse(res);
        res.then()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(SchemaPath.USER_SCHEMA.getPath()));
    }

    @Test(priority = 1)
    public void verifyGetUsers() {
        Response res = users.getUsers();
        AllureManager.attachResponse(res);
        res.then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(SchemaPath.USERS_SCHEMA.getPath()));


    }

}
