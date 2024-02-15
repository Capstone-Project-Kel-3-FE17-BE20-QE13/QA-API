package starter.JobHuntz;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class VacancyByJobSeekerAPI {
    public static String GET_ALL_VACANCIES = Constants.BASE_URL + "/all-vacancies";
    public static String GET_VACANCY_ID = Constants.BASE_URL + "/vacancy/{vacancy_id}";
    public static String POST_VACANCY_BY_JS = Constants.BASE_URL + "/vacancy";
    public static String GET_VACANCY_ID_PARAM = Constants.BASE_URL + "/favorit?vacancy_id={vacancy_id}";
    public static String GET_ALL_FAVORITES = Constants.BASE_URL + "/favorit";
    public static int vacancy_id;

    @Step("Get All Vacancies")
    public void getAllVacancies () {
        SerenityRest.given().header("Authorization","Bearer " + Constants.AUTH_TOKEN);
    }

    @Step ("Vacancy with Id")
    public void vacancyWithId () {
        SerenityRest.given()
                .header("Authorization","Bearer " + Constants.AUTH_TOKEN)
                .pathParam("vacancy_id", vacancy_id);
    }

    @Step ("Post vacancy by job seeker")
    public void postVacancyByJobSeeker (File json) {
        SerenityRest.given()
                .header("Authorization","Bearer " + Constants.AUTH_TOKEN)
                .contentType(ContentType.JSON).body(json);
    }

    @Step ("Vacancy with Id Param")
    public void vacancyWithIdParam () {
        SerenityRest.given()
                .header("Authorization","Bearer " + Constants.AUTH_TOKEN)
                .pathParam("vacancy_id", vacancy_id);
    }

}
