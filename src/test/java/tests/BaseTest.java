package tests;

import api.products.ProductsApi;
import api.users.UsersApi;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utilities.AllureManager;

public class BaseTest {

    protected UsersApi users;
    protected ProductsApi products;

    @BeforeClass
    public void initializeTest() {

        users = new UsersApi();
        products = new ProductsApi();

        AllureManager.logAllure(
                "************ Test Suite Started Successfully ***********************"
        );
    }

    @AfterClass
    public void tearDown() {

        AllureManager.logAllure(
                "************ Test Suite Ended Successfully ***********************"
        );
    }
}