package utilities;

import io.qameta.allure.Allure;
import io.restassured.response.Response;

public class AllureManager {

    public static void attachResponse(Response response){
        Allure.addAttachment("Response","application/json",
                response.asPrettyString(),".json");
    }

}
