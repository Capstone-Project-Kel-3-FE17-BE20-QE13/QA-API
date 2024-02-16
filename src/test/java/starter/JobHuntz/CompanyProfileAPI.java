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
    public void updateCompanyProfile (File json) {
        String token = Constants.COMPANY_TOKEN;
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json").body(json);
    }

    @Step ("Get user details profile")
    public void getCompanyDetails () {
        SerenityRest.given().header("Authorization", "Bearer " + Constants.COMPANY_TOKEN);
    }
    @Step("Update photo company")
    public void setPutPhotoCompany(String image_url) throws IOException {
        Map<String, Object> formData = putImageUrl (image_url);
        putImageUrl1(formData);
    }

    private Map<String, Object> putImageUrl(String image_url) {
        Map<String, Object> formData = new HashMap<>();
        File fileImageUrl = new File(Constants.FILE, image_url);

        formData.put("image_url", fileImageUrl);

        return formData;
    }

    private void putImageUrl1(Map<String, ?> formData) {
        Response response = SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.COMPANY_TOKEN)
                .contentType("multipart/form-data")
                .multiPart("image_url", (File) formData.get("image_url"))
                .put(GET_COMPANY_PROFILE);

        // Add logging or other handling here as needed.
    }
//    public void setPutPhotoCompany
//            (Map<String, ?> formData) {
//        SerenityRest.given()
//                .header("Authorization", "Bearer " + Constants.COMPANY_TOKEN)
//                .contentType("multipart/form-data")
//                .multiPart("image_url",(File) formData.get("image_url"));
//    }


}
