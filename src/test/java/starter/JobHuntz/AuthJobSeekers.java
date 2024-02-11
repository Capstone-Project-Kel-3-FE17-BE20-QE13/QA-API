package starter.JobHuntz;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class AuthJobSeekers {
    public static String LOGIN_JOBSEEKERS = Constants.BASE_URL + "/login/jobseekers";
    public static String REGISTER_JOBSEEKERS = Constants.BASE_URL + "/register/jobseekers";

    @Step ("Login job seekers")
    public void loginJobSeekers (File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON).body(json);
    }

    @Step ("Register job seekers")
    public void registerJobSeekers (File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON).body(json);
    }
}
