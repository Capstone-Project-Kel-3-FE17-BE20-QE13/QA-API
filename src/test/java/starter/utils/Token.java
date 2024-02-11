package starter.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.io.File;

public class Token {
    public static String LOGIN_JOBSEEKER = Constants.BASE_URL + "/login/jobseekers";
    public static String GetToken(File json) throws Exception {
        Response response = RestAssured.given()
                .baseUri(Constants.BASE_URL)
                .contentType(ContentType.JSON).body(json).post(LOGIN_JOBSEEKER);

        return response.jsonPath().getString("data.token");
    }
}
