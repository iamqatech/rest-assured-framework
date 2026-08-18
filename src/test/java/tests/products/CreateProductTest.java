package tests.products;

import api.products.ProductsApi;
import io.restassured.response.Response;
import model.Product;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.AllureManager;

import static org.hamcrest.Matchers.equalTo;

public class CreateProductTest {

    private ProductsApi products;

    @BeforeClass
    public void initializeTest() {
        products = new ProductsApi();
    }

    @Test
    public void verifyCreateProduct() {

        Product product = new Product();

        product.setTitle("Product TestPS");
        product.setPrice(51.51);
        product.setDescription("Test Description");
        product.setCategory("Test");
        product.setImage("https://www.testps.com/image.jpg");

        Response response = products.createProduct(product);

        AllureManager.attachResponse(response);

        response.then()
                .statusCode(HttpStatus.SC_CREATED)
                .body("title", equalTo(product.getTitle()))
                .body("description", equalTo(product.getDescription()))
                .body("category", equalTo(product.getCategory()))
                .body("image", equalTo(product.getImage()));
    }
}