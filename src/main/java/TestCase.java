import io.restassured.http.ContentType;
import org.apache.http.util.Asserts;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestCase {

    public static void main(String[] args) {
        given().baseUri("https://jsonplaceholder.typicode.com")
                .given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")


                .when().get("/posts/1")
                .then()
                .log().body()
                .log().headers()
                .statusCode(200)
                .body("userId", equalTo(1))
                        .assertThat().body("id",equalTo(1));
        System.out.println("Request Executed Successfully. Thanks");
    }
}
