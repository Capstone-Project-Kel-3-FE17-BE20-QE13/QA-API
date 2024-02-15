package starter.JobHuntz;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class VacancybyCompanyGetLowonganAPI {
    public static String GET_ALL_LOWONGAN = Constants.BASE_URL + "/mycompany-vacancies";
    public static String POST_VACANCY_BY_COMPANY = Constants.BASE_URL + "/vacancy";
    @Step("Get All Lowongan")
    public void getAllLowongan () {

        SerenityRest.given().header("Authorization","Bearer " + Constants.COMPANY_TOKEN);
    }
//    @Step ("Post vacancy by company")
//    public void postVacancyByJobSeeker (File json) {
//        SerenityRest.given()
//                .header("Authorization","Bearer " + Constants.AUTH_TOKEN)
//                .contentType(ContentType.JSON).body(json);
//    }


    }

