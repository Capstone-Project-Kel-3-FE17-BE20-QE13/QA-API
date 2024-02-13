package starter.JobHuntzStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.internal.util.SafeExceptionRethrower;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JobHuntz.VacancyByJobSeekerAPI;

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
}
