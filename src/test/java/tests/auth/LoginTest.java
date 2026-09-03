package tests.auth;

import api.auth.LoginApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.BaseTest;

public class LoginTest extends BaseTest {

    LoginApi loginApi = new LoginApi();
    SoftAssert softAssert= new SoftAssert();

    @Test
    public void isLoginSuccessful() {

        Response res = loginApi.getToken("johnd1", "m38rmF$");
        softAssert.assertNotNull(res);
        softAssert.assertEquals(res.getStatusCode(), 201);
        softAssert.assertAll();

    }
}
