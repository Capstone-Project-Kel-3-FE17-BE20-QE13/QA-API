package starter.JobHuntz;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class VacancybyCompanyGetLowonganAPI {
    public static String GET_ALL_LOWONGAN = Constants.BASE_URL + "/mycompany-vacancies";
    public static String GET_VACANCY_ID = Constants.BASE_URL + "/mycompany-vacancies";
    public static int vacancy_id;
    @Step("Get All Lowongan")
    public void getAllLowongan () {

        SerenityRest.given().header("Authorization","Bearer " + Constants.COMPANY_TOKEN);
    }

    @Step ("Vacancy with Id")
    public void vacancyWithId () {
        SerenityRest.given()
                .header("Authorization", "Bearer " + Constants.COMPANY_TOKEN)
                .pathParam("vacancy_id", vacancy_id);


    }
}