package starter.JobHuntzStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JobHuntz.ApplyJobByJobSeekerAPI;

public class ApplyJobByJobseekerStepDef {
    @Steps
    ApplyJobByJobSeekerAPI applyJobByJobSeekerAPI;

    @Given("Job seeker has been logged in and vacancy id {int}")
    public void jobSeekerHasBeenLoggedInAndVacancyId(int id) {
        applyJobByJobSeekerAPI.applyJob(id);
    }

    @When("Send request post apply job")
    public void sendRequestPostApplyJob() {
        SerenityRest.when().post(ApplyJobByJobSeekerAPI.APPLY_JOB);
    }

    @When("Send request get all applications")
    public void sendRequestGetAllApplications() {
        SerenityRest.when().get(ApplyJobByJobSeekerAPI.GET_ALL_APPS);
    }
}
