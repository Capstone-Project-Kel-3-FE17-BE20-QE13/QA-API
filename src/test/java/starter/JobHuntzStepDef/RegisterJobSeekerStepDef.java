package starter.JobHuntzStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JobHuntz.AuthJobSeekersAPI;
import starter.utils.Constants;

import java.io.File;

public class RegisterJobSeekerStepDef {
    @Steps
    AuthJobSeekersAPI authJobSeekersAPI;

    @Given("User register with json file {string}")
    public void userRegisterWithJsonFile(String json) {
        File jsonRegister = new File (Constants.REQ_BODY_DIR + "RegisterJobSeeker/" + json);
        authJobSeekersAPI.registerJobSeekers(jsonRegister);
    }

    @When("Send request post register job seeker")
    public void sendRequestPostRegisterJobSeeker() {
        SerenityRest.when().post(AuthJobSeekersAPI.REGISTER_JOBSEEKERS);
    }

}
