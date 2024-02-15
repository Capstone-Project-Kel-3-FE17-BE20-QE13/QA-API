package starter.JobHuntzStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JobHuntz.AuthCompanyAPI;
import starter.utils.Constants;
import java.io.File;



public class LoginCompanyStepDef {
    @Steps
    AuthCompanyAPI authCompanyAPI;

    @Given("Company login with json file {string}")
    public void userWithJsonFile(String json) {
        File jsonLogin = new File(Constants.REQ_BODY_DIR + "LoginCompany/" + json);
        authCompanyAPI.loginCompany(jsonLogin);
    }

    @When("Send request post login company")
    public void sendRequestPostLoginCompany() {
        Response response = SerenityRest.when().post(AuthCompanyAPI.LOGIN_COMPANY);
        Constants.COMPANY_TOKEN = response.jsonPath().get("data.token");
    }

}

