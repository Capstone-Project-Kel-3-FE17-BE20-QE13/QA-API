package starter.JobHuntzStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import starter.JobHuntz.AuthCompany;
import starter.JobHuntz.AuthJobSeekers;
import starter.utils.Constants;

import java.io.File;

public class RegisterCompanyStepDef {
    @Steps
    AuthCompany authCompany;
    @Given("Company register with json file {string}")
    public void userRegisterWithJsonFile(String json) {
        File jsonRegister = new File (Constants.REQ_BODY_DIR + "/RegisterCompany/" + json);
        authCompany.registerCompany(jsonRegister);
    }
    @When("Send request post register company")
    public void sendRequestPostRegisterCompany() {
        SerenityRest.when().post(AuthCompany.REGISTER_COMPANY);
    }

    @And("Response body message contain {string}")
    public void responseBodyMessageContain(String type) {
        Response bodyContainsResponse = SerenityRest.then().extract().response();
        String responseBody = bodyContainsResponse.getBody().asString();
        Assertions.assertThat(responseBody).contains(type);
    }
}

