package starter.JobHuntzStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JobHuntz.CompanyProfileAPI;
import starter.utils.Constants;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UpdateCompanyStepDef {
    @Steps
    CompanyProfileAPI companyProfileAPI;
//    @Given("Update company with json {string}")
//   public void updateCompanyProfile(String json) {
//        File jsonUpdateCP = new File (Constants.REQ_BODY_DIR + "UpdateCompanyProfile/" + json);
//        companyProfileAPI.updateCompanyProfile(jsonUpdateCP);
//    }
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

    @Given("Update company with form data {string} as image, {string} as company name, {string} as full name, {string} as address, {string} as phone, {string} as company size, {string} as website, and {string} as description")
    public void updateCompanyWithFormDataAsImageAsCompanyNameAsFullNameAsAddressAsPhoneAsCompanySizeAsWebsiteAndAsDescription(String image_url, String company_name, String full_name, String address, String phone, String company_size, String website, String description) throws IOException {
        Map<String, Object> formData = ValidData(image_url, company_name, full_name, address, phone, company_size, website, description);
        companyProfileAPI.updateCompanyProfile(formData);
    }

    private Map<String, Object> ValidData( String image_url, String company_name, String full_name, String address,String phone, String company_size, String website, String description){
        Map<String, Object> formData = new HashMap<>();
        File image = new File(Constants.FILE, image_url);
        formData.put("image_url", image);
        formData.put("company_name", company_name);
        formData.put("full_name", full_name);
        formData.put("address", address);
        formData.put("phone", phone);
        formData.put("company_size", company_size);
        formData.put("website", website);
        formData.put("description", description);

        return formData;
    }

    @Given("Update company with form data {string} as full name")
    public void updateCompanyWithFormDataAsFullName(String full_name) {
        Map<String, Object> formData = ValidData(full_name);
        companyProfileAPI.updateCompanyProfileFullName(formData);
    }

    private Map<String, Object> ValidData( String full_name, String address) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("full_name", full_name);
        formData.put("address", address);

        return formData;
    }

    @Given("Update company with form data {string} as address")
    public void updateCompanyWithFormDataAsAddress(String address) {
        Map<String, Object> formData = ValidData(address);
        companyProfileAPI.updateCompanyProfileAddress(formData);
    }

    private Map<String, Object> ValidData( String address) {
        Map<String, Object> formData = new HashMap<>();
        formData.put("address", address);

        return formData;
    }
}
