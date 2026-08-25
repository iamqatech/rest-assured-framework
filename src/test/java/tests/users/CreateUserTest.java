package tests.users;

import api.users.UsersApi;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import model.User;
import org.apache.http.HttpStatus;
import org.snakeyaml.engine.v2.schema.JsonSchema;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import tests.BaseTest;
import utilities.AllureManager;

import static org.hamcrest.Matchers.equalTo;

public class CreateUserTest extends BaseTest {


    @Test
    public void verifyCreateUser() {

        User user = new User();

        user.setEmail("pstest@gmail.com");
        user.setUsername("testuser");
        user.setPassword("testuser");

        Response response = users.createUser(user);

        AllureManager.attachResponse(response);

        response.then().statusCode(HttpStatus.SC_CREATED);
    }
}