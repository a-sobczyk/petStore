package org.petStore.pet.steps;

import org.petStore.BaseTest;
import org.petStore.pet.pojo.response.GetPetByIdResponse;
import static io.restassured.RestAssured.given;

public class GetPetSteps extends BaseTest {

    protected void getPetByIdStep(int id) {
        GetPetByIdResponse response = given()
                .when().get(ENDPOINTS.getProperty("GET_PET_BY_ID") + id)
                .then().log().all().extract().response().as(GetPetByIdResponse.class);
    }
}
