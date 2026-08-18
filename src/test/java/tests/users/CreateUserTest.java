package tests.users;

import api.users.UsersApi;
import io.restassured.response.Response;
import model.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.AllureManager;

import static org.hamcrest.Matchers.equalTo;

public class CreateUserTest {

    private UsersApi users;

    @BeforeClass
    public void initializeTest() {
        users = new UsersApi();
    }

    @Test
    public void verifyCreateUser() {

        User user = new User();

        user.setEmail("pstest@gmail.com");
        user.setUsername("testuser");
        user.setPassword("testuser");

        Response response = users.createUser(user);

        AllureManager.attachResponse(response);

        int id = response.body().jsonPath().getInt("id");

        users.getUser(id).then()
                .body("username", equalTo(user.getUsername()))
                .body("password", equalTo(user.getPassword()))
                .body("email", equalTo(user.getEmail()));

    }
}