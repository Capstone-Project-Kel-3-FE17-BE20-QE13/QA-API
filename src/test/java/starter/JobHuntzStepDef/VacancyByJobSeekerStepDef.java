package starter.JobHuntzStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.internal.util.SafeExceptionRethrower;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JobHuntz.VacancyByJobSeekerAPI;
import starter.utils.Constants;

import java.io.File;

public class VacancyByJobSeekerStepDef {
    @Steps
    VacancyByJobSeekerAPI vacancyByJobSeekerAPI;

    @Given("Job seeker has logged in")
    public void jobSeekerHasLoggedIn() {
        vacancyByJobSeekerAPI.getAllVacancies();
    }

    @When("Send request get all vacancies")
    public void sendRequestGetAllVacancies() {
        Response response = SerenityRest.when().get(VacancyByJobSeekerAPI.GET_ALL_VACANCIES);
        VacancyByJobSeekerAPI.vacancy_id = response.jsonPath().get("data[0].id");
    }

    @Given("Vacancy with valid id")
    public void vacancyWithValidId() {
        vacancyByJobSeekerAPI.vacancyWithId();
    }

    @When("Send request get detail vacancy")
    public void sendRequestGetDetailVacancy() {

        SerenityRest.when().get(VacancyByJobSeekerAPI.GET_VACANCY_ID);
    }

    @Given("Job seeker has logged in and file json {string}")
    public void jobSeekerHasLoggedInAndFileJson(String json) {
        File jsonPostVacancy = new File (Constants.REQ_BODY_DIR + "VacancyByJobSeeker/" + json);
        vacancyByJobSeekerAPI.postVacancyByJobSeeker(jsonPostVacancy);
    }

    @When("Send request post new vacancy by job seeker")
    public void sendRequestPostNewVacancyByJobSeeker() {
        SerenityRest.when().post(VacancyByJobSeekerAPI.POST_VACANCY_BY_JS);
    }

    @Given("Job seeker has logged in and valid vacancy id")
    public void jobSeekerHasLoggedInAndValidVacancyId() {
        vacancyByJobSeekerAPI.vacancyWithIdParam();
    }

    @When("Send request add vacancy to favorite")
    public void sendRequestAddVacancyToFavorite() {
        SerenityRest.when().post(VacancyByJobSeekerAPI.GET_VACANCY_ID_PARAM);
    }

    @When("Send request delete vacancy from favorite")
    public void sendRequestDeleteVacancyFromFavorite() {
        SerenityRest.when().delete(VacancyByJobSeekerAPI.GET_VACANCY_ID);
    }

    @When("Send request get all favorite vacancies")
    public void sendRequestGetAllFavoriteVacancies() {
        SerenityRest.when().get(VacancyByJobSeekerAPI.GET_ALL_FAVORITES);
    }
}
