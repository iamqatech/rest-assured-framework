package tests.products;

import api.products.ProductsApi;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.AllureManager;
import utilities.SchemaPath;

public class GetProductsTest {

    public ProductsApi products;

    @BeforeClass
    public void initializeTest() {

        products = new ProductsApi();

    }

    @Test(priority = 2)
    public void verifyGetProductById() {
        Response res = products.getProduct(1);
        AllureManager.attachResponse(res);
        res.then().statusCode(HttpStatus.SC_OK).assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(SchemaPath.PRODUCT_SCHEMA.getPath()));
    }

    @Test(priority = 1)
    public void getProducts() {
        Response res = products.getProducts();
        AllureManager.attachResponse(res);
        res.then()
                .log().ifValidationFails()
        .statusCode(HttpStatus.SC_OK)
        .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(SchemaPath.PRODUCTS_SCHEMA.getPath()));


    }

}
