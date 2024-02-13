package starter.JobHuntz;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class VacancyByJobSeekerAPI {
    public static String GET_ALL_VACANCIES = Constants.BASE_URL + "/all-vacancies";
    public static String GET_VACANCY_ID = Constants.BASE_URL + "/vacancy/{vacancy_id}";
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
}
