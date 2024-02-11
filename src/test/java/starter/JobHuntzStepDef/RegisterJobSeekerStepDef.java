package starter.JobHuntzStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JobHuntz.AuthJobSeekers;
import starter.utils.Constants;

import java.io.File;

public class RegisterJobSeekerStepDef {
    @Steps
    AuthJobSeekers authJobSeekers;

    @Given("User register with json file {string}")
    public void userRegisterWithJsonFile(String json) {
        File jsonRegister = new File (Constants.REQ_BODY_DIR + "/RegisterJobSeeker/" + json);
        authJobSeekers.registerJobSeekers(jsonRegister);
    }

    @When("Send request post register job seeker")
    public void sendRequestPostRegisterJobSeeker() {
        SerenityRest.when().post(AuthJobSeekers.REGISTER_JOBSEEKERS);
    }
}
