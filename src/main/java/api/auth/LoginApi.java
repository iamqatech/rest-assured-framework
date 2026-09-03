package api.auth;

import io.restassured.response.Response;
import utilities.Helper;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class LoginApi {


    final String baseUrl = Helper.getProperty("baseUrl");

    public Response getToken(String username, String password) {

        HashMap<String, String> authDetails = new HashMap<>();
        authDetails.put("username",username);
        authDetails.put("password",password);
        return given().baseUri(baseUrl)
                .header("Accept", "application/json")
                .header("Content-Type","application/json")
                .body(authDetails)
                .when()
                .post("/auth/login");
    }

}
