package starter.JobHuntz;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;
import java.util.Map;

public class JobSeekersProfileAPI {
    public static String UPDATE_PROFILE_JS = Constants.BASE_URL + "/jobseekers";
    public static String GET_JS_PROFILE = Constants.BASE_URL + "/jobseekers";
    public static String POST_CV = Constants.BASE_URL + "/cv";
    public static String GET_CV = Constants.BASE_URL + "/cv";
    public static String POST_CAREER = Constants.BASE_URL + "/career";
    public static String GET_ALL_CAREERS = Constants.BASE_URL + "/all-careers";
    public static String GET_CAREER_WITH_ID = Constants.BASE_URL + "/career/{career_id}";
    public static int career_id;
    public static int skill_id;
    public static int education_id;
    public static int license_id;
    public static String POST_LICENSE = Constants.BASE_URL + "/license";
    public static String ALL_LICENSES = Constants.BASE_URL + "/all-licenses";
    public static String LICENSE_ID = Constants.BASE_URL + "/license/{license_id}";
    public static String POST_EDUCATION = Constants.BASE_URL + "/education";
    public static String ALL_EDUCATIONS = Constants.BASE_URL + "/all-educations";
    public static String EDUCATION_ID = Constants.BASE_URL + "/education/{education_id}";
    public static String POST_SKILL = Constants.BASE_URL + "/skill";
    public static String ALL_SKILLS = Constants.BASE_URL + "/all-skills";
    public static String SKILL_ID = Constants.BASE_URL + "/skill/{skill_id}";

    @Step ("Update job seeker profile")
    public void updateJobSeekerProfile (File json) {
        String token = Constants.AUTH_TOKEN;
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json").body(json);
    }

    @Step ("Get user details profile")
    public void getJobSeekerDetails () {
        SerenityRest.given().header("Authorization", "Bearer " + Constants.AUTH_TOKEN);
    }

    @Step ("Post file cv job seeker")
    public void postFileCV (Map<String, ?> formData) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.AUTH_TOKEN)
                .contentType("multipart/form-data")
                .multiPart("cv_file",(File) formData.get("cv_file"));
    }

    @Step ("Get job seeker cv")
    public void getJSCV () {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.AUTH_TOKEN);
    }

    @Step ("Post job seeker career")
    public void postJSCareer (File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.AUTH_TOKEN)
                .contentType(ContentType.JSON).body(json);
    }

    @Step ("Get all job seeker careers")
    public void getAllJSCareers () {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.AUTH_TOKEN);
    }

    @Step ("Get career with career id")
    public void getCareerWithId () {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.AUTH_TOKEN)
                .pathParam("career_id", career_id);
    }

    @Step ("Put job seeker career")
    public void putJSCareer (File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.AUTH_TOKEN)
                .pathParam("career_id", career_id)
                .contentType(ContentType.JSON).body(json);
    }

    @Step ("Post license job seeker")
    public void postJSLicense (Map<String, ?> formData) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.AUTH_TOKEN)
                .contentType("multipart/form-data")
                .multiPart("license_name", formData.get("license_name"))
                .multiPart("pub_date", formData.get("pub_date"))
                .multiPart("exp_date", formData.get("exp_date"))
                .multiPart("license",(File) formData.get("license"));
    }

    @Step ("Post license job seeker")
    public void putJSLicense (Map<String, ?> formData) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.AUTH_TOKEN)
                .pathParam("license_id", license_id)
                .contentType("multipart/form-data")
                .multiPart("license_name", formData.get("license_name"))
                .multiPart("pub_date", formData.get("pub_date"))
                .multiPart("exp_date", formData.get("exp_date"))
                .multiPart("license",(File) formData.get("license"));
    }

    @Step ("Get all job seeker licenses")
    public void getAllLicenses () {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.AUTH_TOKEN);
    }

    @Step ("Get license with id")
    public void getLicenseWithId () {
        SerenityRest.given()
                .pathParam("license_id", license_id)
                .header("Authorization", "Bearer " + Constants.AUTH_TOKEN);
    }

    @Step ("Post job seeker education")
    public void postJSEducation (File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.AUTH_TOKEN)
                .contentType(ContentType.JSON).body(json);
    }

    @Step ("Get all job seeker educations")
    public void getAllEducations () {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.AUTH_TOKEN);
    }

    @Step ("Get education with education id")
    public void getEducationWithId () {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.AUTH_TOKEN)
                .pathParam("education_id", education_id);
    }

    @Step ("Put job seeker education")
    public void putJSEducation (File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.AUTH_TOKEN)
                .pathParam("education_id", education_id)
                .contentType(ContentType.JSON).body(json);
    }

    @Step ("Post job seeker skill")
    public void postJSSkill (File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.AUTH_TOKEN)
                .contentType(ContentType.JSON).body(json);
    }

    @Step ("Get all job seeker skills")
    public void getAllSkills () {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.AUTH_TOKEN);
    }

    @Step ("Get skill with skill id")
    public void getSkillWithId () {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.AUTH_TOKEN)
                .pathParam("skill_id", skill_id);
    }

    @Step ("Put job seeker skill")
    public void putJSSkill (File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.AUTH_TOKEN)
                .pathParam("skill_id", skill_id)
                .contentType(ContentType.JSON).body(json);
    }

}
