package starter.JobHuntz;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class AuthJobSeekers {
    public static String LOGIN_JOBSEEKERS = Constants.BASE_URL + "/login/jobseekers";

    @Step ("Login job seekers valid")
    public void loginJobSeekersValid (File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
}
