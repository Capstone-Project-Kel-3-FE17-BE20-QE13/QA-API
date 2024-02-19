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

//    @Given("Update image {string}")
//    public void updateImage(String image_url) throws IOException {
////        Map<String, Object> formData = ValidData(image_url);
//        companyProfileAPI.setPutPhotoCompany(image_url);
//    }
//    private Map<String, Object> ValidData( String image_url, String company_name) {
//        Map<String, Object> formData = new HashMap<>();
//        File fileImage = new File(Constants.FILE, image_url);
//        formData.put("image_url", fileImage);
//        formData.put("company_name", company_name);
//
//        return formData;
//    }
//    @Given("Update company with form data {string} as image, {string} as company name, {string} as full name, {string} as address, {int} as phone, {string} as company size, {string} as website, and {string} as description")
//    public void updateCompanyWithFormDataAsCompanyNameAsFullNameAsAddressAsPhoneAsCompanySizeAsWebsiteAsDescriptionAndAsImage(String image_url, String company_name, String full_name, String address, int phone, String company_size, String website, String description) throws IOException {
//        Map<String, Object> formData = ValidData(image_url, company_name, full_name, address, phone, company_size, website, description);
//        companyProfileAPI.updateCompanyProfile(formData);
//    }
//
//    private Map<String, Object> ValidData( String image_url, String company_name, String full_name, String address, int phone, String company_size, String website, String description) {
//        Map<String, Object> formData = new HashMap<>();
//        File image = new File(Constants.FILE, image_url);
//        formData.put("image_url", image);
//        formData.put("company_name", company_name);
//        formData.put("full_name", full_name);
//        formData.put("address", address);
//        formData.put("phone", phone);
//        formData.put("company_size", company_size);
//        formData.put("website", website);
//        formData.put("description", description);
//
//        return formData;
//    }

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

//    private Map<String, Object> ValidData(String company_name) {
//        Map<String, Object> formData = new HashMap<>();
//        formData.put("company_name", company_name);
//        return formData;
//    }
}
