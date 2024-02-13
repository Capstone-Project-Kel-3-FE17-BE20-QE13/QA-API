package starter.JobHuntz;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class AuthCompanyAPI {
    public static String LOGIN_COMPANY = Constants.BASE_URL + "/login/company";
    public static String REGISTER_COMPANY = Constants.BASE_URL + "/register/company";

    @Step("Login company")
    public void loginCompany (File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON).body(json);
    }

    @Step ("Register Company")
    public void registerCompany (File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON).body(json);
    }


}
