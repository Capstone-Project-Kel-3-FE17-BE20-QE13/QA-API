package starter.JobHuntzStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JobHuntz.AuthJobSeekers;
import starter.JobHuntz.JobHuntzResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class LoginJobSeekersStepDef {
    @Steps
    AuthJobSeekers authJobSeekers;

    @Given("User with json file {string}")
    public void userWithJsonFile(String json) {
        File jsonLogin = new File (Constants.REQ_BODY_DIR + json);
        authJobSeekers.loginJobSeekersValid(jsonLogin);
    }

    @When("Send request post login job seeker")
    public void sendRequestPostLoginJobSeeker() {
        SerenityRest.when().post(AuthJobSeekers.LOGIN_JOBSEEKERS);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int responseCode) {
        SerenityRest.then().statusCode(responseCode);
    }

    @And("Response body message was {string}")
    public void responseBodyMessageWas(String message) {
        SerenityRest.and().body(JobHuntzResponses.MESSAGE, equalTo(message));
    }

    @And("Validate json schema {string}")
    public void validateJsonSchema(String json) {
        File jsonSchema = new File (Constants.JSON_SCHEMA_DIR + json);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

}
