package starter.JobHuntz;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CompanyProfileAPI {
    public static String UPDATE_PROFILE_COMPANY = Constants.BASE_URL + "/company";
    public static String GET_COMPANY_PROFILE = Constants.BASE_URL + "/company";
    @Step("Update company profile")
    public void updateCompanyProfile (Map<String, ?> formData) throws IOException {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.COMPANY_TOKEN)
                .contentType("multipart/form-data")
                .multiPart("image_url",(File) formData.get("image_url"))
                .multiPart("company_name", formData.get("company_name"))
                .multiPart("full_name", formData.get("full_name"))
                .multiPart("address", formData.get("address"))
                .multiPart("phone", formData.get("company_size"))
                .multiPart("company_size", formData.get("company_size"))
                .multiPart("website", formData.get("website"))
                .multiPart("description", formData.get("description"));
    }

    @Step ("Get user details profile")
    public void getCompanyDetails () {
        SerenityRest.given().header("Authorization", "Bearer " + Constants.COMPANY_TOKEN);
    }
//    @Step("Update company profile")
//    public void setPutPhotoCompany(String image_url, String company_name, String full_name, String address, String phone, String company_size, String website, String description) throws IOException {
//        Map<String, Object> formData = putImageUrl (image_url);
//        putImageUrl1(formData);
//
//    }

//    private Map<String, Object> putImageUrl(String image_url) {
//        Map<String, Object> formData = new HashMap<>();
//        File fileImageUrl = new File(Constants.FILE, image_url);
//
//        formData.put("image_url", fileImageUrl);
//
//        return formData;
//    }
//
//    private void putImageUrl1(Map<String, ?> formData) {
//        Response response = SerenityRest.given()
//                .header("Authorization", "Bearer " + Constants.COMPANY_TOKEN)
//                .contentType("multipart/form-data")
//                .multiPart("image_url", (File) formData.get("image_url"))
//                .put(GET_COMPANY_PROFILE);
//    }


}
