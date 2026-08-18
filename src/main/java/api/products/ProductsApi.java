package api.products;

import io.restassured.response.Response;
import model.Product;
import utilities.Helper;

import static io.restassured.RestAssured.given;

public class ProductsApi {

    final String baseUrl = Helper.getProperty("baseUrl");

    public Response getProduct(int productId) {

        return given().baseUri(baseUrl)
                .header("Accept", "application/json")
                .when()
                .get("/products/" + productId);
    }

    public Response getProducts() {

        return given().baseUri(baseUrl)
                .header("Accept", "application/json")
                .when()
                .get("/products");
    }

    public Response createProduct(Product product) {

        return given().baseUri(baseUrl).body(product)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .post("/products/");
    }

}
