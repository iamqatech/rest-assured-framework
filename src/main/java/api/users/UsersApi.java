package api.users;

import io.restassured.response.Response;
import utilities.Helper;

import static io.restassured.RestAssured.given;

public class UsersApi {

    final String baseUrl = Helper.getProperty("baseUrl");

    public Response getUser(int userId) {

        return given().baseUri(baseUrl)
                .header("Accept", "application/json")
                .when()
                .get("/users/"+userId);
    }

    public Response getUsers() {

        return given().baseUri(baseUrl)
                .header("Accept", "application/json")
                .when()
                .get("/users");
    }

}


