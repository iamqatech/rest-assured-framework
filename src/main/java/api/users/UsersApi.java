package api.users;

import io.restassured.response.Response;
import jdk.jfr.ContentType;
import model.User;
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


    public Response createUser(User user) {

        return given().baseUri(baseUrl).body(user)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .post("/users");
    }

}


