package starter.JobHuntzStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JobHuntz.AuthCompany;
import starter.JobHuntz.AuthJobSeekers;
import starter.JobHuntz.JobHuntzResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;


public class LoginCompanyStepDef {
    @Steps
    AuthCompany authCompany;
    @Given("Company login with json file {string}")
    public void userWithJsonFile(String json) {
        File jsonLogin = new File (Constants.REQ_BODY_DIR + "/LoginCompany/" + json);
        authCompany.loginCompany(jsonLogin);
    }
    @When("Send request post login company")
    public void sendRequestPostLoginCompany() {
        SerenityRest.when().post(AuthCompany.LOGIN_COMPANY);
    }

}
