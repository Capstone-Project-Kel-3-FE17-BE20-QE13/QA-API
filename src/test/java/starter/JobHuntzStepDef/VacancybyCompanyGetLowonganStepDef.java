package starter.JobHuntzStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JobHuntz.VacancyByJobSeekerAPI;
import starter.JobHuntz.VacancybyCompanyGetLowonganAPI;

public class VacancybyCompanyGetLowonganStepDef {
    @Steps
    VacancybyCompanyGetLowonganAPI vacancybyCompanyGetLowonganAPI;
    @Given("Company create a job vacancy")
    public void companyCreateJob() {
        vacancybyCompanyGetLowonganAPI.getAllLowongan();
    }
    @When("Send request get vacancy")
    public void sendRequestGetVacancy() {
      SerenityRest.when().get(VacancybyCompanyGetLowonganAPI.GET_ALL_LOWONGAN);

    }

}
