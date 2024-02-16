package starter.JobHuntz;

import io.restassured.internal.util.SafeExceptionRethrower;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class ApplyJobByJobSeekerAPI {
    public static String APPLY_JOB = Constants.BASE_URL + "/application?vacancy_id={vacancy_id}";
    public static String GET_ALL_APPS = Constants.BASE_URL + "/applications-jobseeker";

    @Step ("Apply job by vacancy id")
    public void applyJob (int id) {
        SerenityRest.given()
                .header("Authorization","Bearer " + Constants.AUTH_TOKEN)
                .pathParam("vacancy_id", id);
    }
}
