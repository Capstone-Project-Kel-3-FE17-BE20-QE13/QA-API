package starter.JobHuntzStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import starter.JobHuntz.CompanyProfileAPI;
import starter.JobHuntz.JobSeekersProfileAPI;
import starter.utils.Constants;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static starter.JobHuntz.CompanyProfileAPI.GET_COMPANY_PROFILE;

public class UpdateCompanyStepDef {
    @Steps
    CompanyProfileAPI companyProfileAPI;
    @Given("Update company with json {string}")
   public void updateCompanyProfile(String json) {
        File jsonUpdateCP = new File (Constants.REQ_BODY_DIR + "UpdateCompanyProfile/" + json);
        companyProfileAPI.updateCompanyProfile(jsonUpdateCP);
    }
    @When("Send request put update company")
    public void sendRequestPutUpdateCompany() {
        SerenityRest.when().put(CompanyProfileAPI.UPDATE_PROFILE_COMPANY);

    }

    @Given("Get details user company")
    public void getDetailsUserCompany() {
        companyProfileAPI.getCompanyDetails();
    }

    @When("Send request get user profile company")
    public void sendRequestGetCompanyProfile() {
        SerenityRest.when().get(CompanyProfileAPI.GET_COMPANY_PROFILE);
    }

    @Given("Update image {string}")
    public void updateImage(String image_url) throws IOException {
//        Map<String, Object> formData = ValidData(image_url);
        companyProfileAPI.setPutPhotoCompany(image_url);
    }
    private Map<String, Object> ValidData( String image_url) {
        Map<String, Object> formData = new HashMap<>();
        File fileImage = new File(Constants.FILE, image_url);
        formData.put("image_url", fileImage);

        return formData;
    }

}
