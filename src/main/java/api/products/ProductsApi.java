package api.products;

import io.restassured.response.Response;
import utilities.Helper;

import static io.restassured.RestAssured.given;

public class ProductsApi {

    final String baseUrl = Helper.getProperty("baseUrl");

    public Response getProduct(int productId) {

        return given().baseUri(baseUrl)
                .header("Accept", "application/json")
                .when()
                .get("/products/"+productId);
    }

    public Response getProducts() {

        return given().baseUri(baseUrl)
                .header("Accept", "application/json")
                .when()
                .get("/products");
    }

}
