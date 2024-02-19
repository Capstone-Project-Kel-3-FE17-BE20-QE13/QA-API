package starter.JobHuntzStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.JobHuntz.AuthJobSeekersAPI;
import starter.JobHuntz.JobSeekersProfileAPI;
import starter.utils.Constants;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UpdateJobSeekerStepDef {
    @Steps
    JobSeekersProfileAPI jobSeekersProfileAPI;

    @Given("Update job seeker with json {string}")
    public void updateUserWithValidJson(String json) {
        File jsonUpdateJSProfile = new File (Constants.REQ_BODY_DIR + "UpdateJobSeekerProfile/" + json);
        jobSeekersProfileAPI.updateJobSeekerProfile(jsonUpdateJSProfile);
    }

    @When("Send request put update job seeker")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(JobSeekersProfileAPI.UPDATE_PROFILE_JS);
    }

    @Given("Get details user profile")
    public void getDetailsUserProfile() {
        jobSeekersProfileAPI.getJobSeekerDetails();
    }

    @When("Send request get user profile")
    public void sendRequestGetUserProfile() {
        SerenityRest.when().get(JobSeekersProfileAPI.GET_JS_PROFILE);
    }

    @Given("Job seeker with file {string}")
    public void jobSeekerFile(String cv_file) {
        Map<String, Object> formData = ValidData(cv_file);
        jobSeekersProfileAPI.postFileCV(formData);
    }
    private Map<String, Object> ValidData( String cv_file) {
        Map<String, Object> formData = new HashMap<>();
        File fileCV = new File(Constants.FILE, cv_file);
        formData.put("cv_file", fileCV);

        return formData;
    }

    @When("Send request post file")
    public void sendRequestPostFile() {
        SerenityRest.when().post(JobSeekersProfileAPI.POST_CV);
    }

    @Given("Job seeker with valid cv")
    public void jobSeekerWithValidCv() {
        jobSeekersProfileAPI.getJSCV();
    }

    @When("Send request get cv")
    public void sendRequestGetCv() {
        SerenityRest.when().get(JobSeekersProfileAPI.GET_CV);
    }

    @When("Send request put file")
    public void sendRequestPutFile() {
        SerenityRest.when().put(JobSeekersProfileAPI.POST_CV);
    }

    @When("Send request delete file")
    public void sendRequestDeleteFile() {
        SerenityRest.when().delete(JobSeekersProfileAPI.POST_CV);
    }

    @Given("Post user career with json {string}")
    public void postUserCareerWithJson(String json) {
        File jsonCareer = new File (Constants.REQ_BODY_DIR + "UpdateJobSeekerProfile/" + json);
        jobSeekersProfileAPI.postJSCareer(jsonCareer);
    }

    @When("Send request post user career")
    public void sendRequestPostUserCareer() {
        SerenityRest.when().post(JobSeekersProfileAPI.POST_CAREER);
    }

    @Given("Get all user careers")
    public void getAllUserCareers() {
        jobSeekersProfileAPI.getAllJSCareers();
    }

    @When("Send request get all user careers")
    public void sendRequestGetAllUserCareers() {
        Response response = SerenityRest.when().get(JobSeekersProfileAPI.GET_ALL_CAREERS);
            JobSeekersProfileAPI.career_id = response.jsonPath().get("data[0].id");
    }

    @Given("Get user career with valid id")
    public void getUserCareerWithValidId()  {
        jobSeekersProfileAPI.getCareerWithId();
    }

    @When("Send request get user career with career id")
    public void sendRequestGetUserCareerWithCareerId() {
        SerenityRest.when().get(JobSeekersProfileAPI.GET_CAREER_WITH_ID);
    }

    @Given("Put user career with json {string} dan valid id")
    public void putUserCareerWithJsonDanValidId(String json) {
        File jsonCareer = new File (Constants.REQ_BODY_DIR + "UpdateJobSeekerProfile/" + json);
        jobSeekersProfileAPI.putJSCareer(jsonCareer);
    }

    @When("Send request put user career")
    public void sendRequestPutUserCareer() {
        SerenityRest.when().put(JobSeekersProfileAPI.GET_CAREER_WITH_ID);
    }

    @When("Send request delete user career")
    public void sendRequestDeleteUserCareer() {
        SerenityRest.when().delete(JobSeekersProfileAPI.GET_CAREER_WITH_ID);
    }

    @Given("Job seeker with valid license id and form data {string}, {string}, {string}, and {string}")
    public void jobSeekerWithLicenseIDAndFormData(String license_name, String pub_date, String exp_date, String license) {
        Map<String, Object> formData = ValidData(license_name, pub_date, exp_date, license);
        jobSeekersProfileAPI.putJSLicense(formData);
    }

    @Given("Job seeker with {string}, {string}, {string}, and {string}")
    public void jobSeekerWithFormData(String license_name, String pub_date, String exp_date, String license) {
        Map<String, Object> formData = ValidData(license_name, pub_date, exp_date, license);
        jobSeekersProfileAPI.postJSLicense(formData);
    }

    private Map<String, Object> ValidData(String license_name, String pub_date, String exp_date, String license) {
        Map<String, Object> formData = new HashMap<>();
        File licenseFile = new File(Constants.FILE, license);
        formData.put("license", licenseFile);
        formData.put("license_name", license_name);
        formData.put("pub_date", pub_date);
        formData.put("exp_date", exp_date);

        return formData;
    }

    @When("Send request post user license")
    public void sendRequestPostUserLicense() {
        SerenityRest.when().post(JobSeekersProfileAPI.POST_LICENSE);
    }

    @Given("Job seeker licenses")
    public void jobSeekerLicenses() {
        jobSeekersProfileAPI.getAllLicenses();
    }

    @When("Send request get all user licenses")
    public void sendRequestGetAllUserLicenses() {
        Response response = SerenityRest.when().get(JobSeekersProfileAPI.ALL_LICENSES);
        JobSeekersProfileAPI.license_id = response.jsonPath().get("data[0].id");
    }

    @Given("Job seeker license with valid id")
    public void jobSeekerLicenseWithId() {
        jobSeekersProfileAPI.getLicenseWithId();
    }

    @When("Send request get license with id")
    public void sendRequestGetLicenseWithId() {
        SerenityRest.when().get(JobSeekersProfileAPI.LICENSE_ID);
    }

    @When("Send request put license with id")
    public void sendRequestPutLicenseWithId() {
        SerenityRest.when().put(JobSeekersProfileAPI.LICENSE_ID);
    }

    @When("Send request delete license with id")
    public void sendRequestDeleteLicenseWithId() {
        SerenityRest.when().delete(JobSeekersProfileAPI.LICENSE_ID);
    }

    @Given("Post user education with json {string}")
    public void postUserEducationWithJson(String json) {
        File jsonEducation = new File (Constants.REQ_BODY_DIR + "UpdateJobSeekerProfile/" + json);
        jobSeekersProfileAPI.postJSEducation(jsonEducation);
    }

    @When("Send request post user education")
    public void sendRequestPostUserEducation() {
        SerenityRest.when().post(JobSeekersProfileAPI.POST_EDUCATION);
    }

    @Given("Get all user educations")
    public void getAllUserEducations() {
        jobSeekersProfileAPI.getAllEducations();
    }

    @When("Send request get all user educations")
    public void sendRequestGetAllUserEducations() {
        Response response = SerenityRest.when().get(JobSeekersProfileAPI.ALL_EDUCATIONS);
        JobSeekersProfileAPI.education_id = response.jsonPath().get("data[0].id");
    }

    @Given("Get user education with valid id")
    public void getUserEducationWithValidId() {
        jobSeekersProfileAPI.getEducationWithId();
    }

    @When("Send request get user education with education id")
    public void sendRequestGetUserEducationWithEducationId() {
        SerenityRest.when().get(JobSeekersProfileAPI.EDUCATION_ID);
    }

    @Given("Put user education with json {string} and valid id")
    public void putUserEducationWithJsonDanValidId(String json) {
        File jsonEducation = new File (Constants.REQ_BODY_DIR + "UpdateJobSeekerProfile/" + json);
        jobSeekersProfileAPI.putJSEducation(jsonEducation);
    }

    @When("Send request put user education")
    public void sendRequestPutUserEducation() {
        SerenityRest.when().put(JobSeekersProfileAPI.EDUCATION_ID);
    }

    @When("Send request delete user education")
    public void sendRequestDeleteUserEducation() {
        SerenityRest.when().delete(JobSeekersProfileAPI.EDUCATION_ID);
    }

    @Given("Post user skill with json {string}")
    public void postUserSkillWithJson(String json) {
        File jsonSkill = new File (Constants.REQ_BODY_DIR + "UpdateJobSeekerProfile/" + json);
        jobSeekersProfileAPI.postJSSkill(jsonSkill);
    }

    @When("Send request post user skill")
    public void sendRequestPostUserSkill() {
        SerenityRest.when().post(JobSeekersProfileAPI.POST_SKILL);
    }

    @Given("Get all user skills")
    public void getAllUserSkills() {
        jobSeekersProfileAPI.getAllSkills();
    }

    @When("Send request get all user skills")
    public void sendRequestGetAllUserSkills() {
        Response response = SerenityRest.when().get(JobSeekersProfileAPI.ALL_SKILLS);
        JsonPath jsonPathEvaluator = response.jsonPath();
        JobSeekersProfileAPI.skill_id = jsonPathEvaluator.get("data[0].id");
    }

    @Given("Get user skill with valid id")
    public void getUserSkillWithValidId() {
        jobSeekersProfileAPI.getSkillWithId();
    }

    @When("Send request get user skill with skill id")
    public void sendRequestGetUserSkillWithSkillId() {
        SerenityRest.when().get(JobSeekersProfileAPI.SKILL_ID);
    }

    @Given("Put user skill with json {string} and valid id")
    public void putUserSkillWithJsonDanValidId(String json) {
        File jsonSkill = new File (Constants.REQ_BODY_DIR + "UpdateJobSeekerProfile/" + json);
        jobSeekersProfileAPI.putJSSkill(jsonSkill);
    }

    @When("Send request put user skill")
    public void sendRequestPutUserSkill() {
        SerenityRest.when().put(JobSeekersProfileAPI.SKILL_ID);
    }

    @When("Send request delete user skill")
    public void sendRequestDeleteUserSkill() {
        SerenityRest.when().delete(JobSeekersProfileAPI.SKILL_ID);
    }

}
