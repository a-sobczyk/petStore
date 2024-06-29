package org.petStore.pet.steps;

import org.petStore.BaseTest;
import org.petStore.pet.pojo.models.Category;
import org.petStore.pet.pojo.models.Tags;
import org.petStore.pet.pojo.response.GetPetByIdResponse;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class GetPetSteps extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    protected GetPetByIdResponse getPetByIdStep(int id) {
        return given()
                .when().get(ENDPOINTS.getProperty("GET_PET_BY_ID") + id)
                .then().log().all().extract().response().as(GetPetByIdResponse.class);
    }

    protected void validateResponseData(GetPetByIdResponse response) {
        softAssert.assertEquals(response.getId().toString(), "968968112", "Check pet \"id\"");
        softAssert.assertEquals(response.getName(), "Piesel", "Check pet \"name\"");
        softAssert.assertEquals(response.getStatus(), "pending", "Check pet \"status\"");
        softAssert.assertEquals(response.getPhotoUrls().get(0), "foto/piesel_123", "Check pet \"photoUrls\"");

        Category category = response.getCategory();
        softAssert.assertEquals(category.getId().toString(), "0", "Check pet.category \"id\"");
        softAssert.assertEquals(category.getName(), "Psy", "Check pet.category \"name\"");

        Tags tags = response.getTags().get(0);
        softAssert.assertEquals(tags.getId().toString(), "159", "Check pet.tags \"id\"");
        softAssert.assertEquals(tags.getName(), "Piesely", "Check pet.tags \"name\"");
        softAssert.assertAll();
    }
}
