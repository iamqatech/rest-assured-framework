package tests;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utilities.SchemaPath;

import static io.restassured.RestAssured.given;
import static utilities.Helper.getProperty;

public class Products {

    public static String baseUrl = getProperty("baseUrl");

    @Test(priority = 2)
    public void getProduct() {
        given().baseUri(baseUrl)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .when().get("/Products/1")
                .then().statusCode(HttpStatus.SC_OK)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(SchemaPath.PRODUCT_SCHEMA.getPath()));
    }

    @Test(priority = 1)
    public void getProducts() {
        given().baseUri(baseUrl)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .when().get("/Products")
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(SchemaPath.PRODUCTS_SCHEMA.getPath()));


    }

}
