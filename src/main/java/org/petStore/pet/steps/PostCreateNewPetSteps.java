package org.petStore.pet.steps;

import org.petStore.BaseTest;
import org.petStore.pet.pojo.models.Category;
import org.petStore.pet.pojo.models.Tags;
import org.petStore.pet.pojo.request.PostCreateNewPetRequest;
import org.petStore.pet.pojo.response.PetResponse;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostCreateNewPetSteps extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    protected PostCreateNewPetRequest prepareNewPet() {
        PostCreateNewPetRequest newPet = new PostCreateNewPetRequest();
        newPet.setId(968968112);
        newPet.setName("Piesel");
        newPet.setStatus("pending");
        Category category = new Category();
        category.setId(0);
        category.setName("Psy");
        newPet.setCategory(category);
        List<String> photoUrlList = Arrays.asList("foto/piesel_123");
        newPet.setPhotoUrls(photoUrlList);
        Tags tags = new Tags();
        tags.setId(159);
        tags.setName("Piesely");
        List<Tags> tagsList = new ArrayList<>();
        tagsList.add(tags);
        tags.setName("Piesely");
        newPet.setTags(tagsList);
        return newPet;
    }

    protected PetResponse postCreateNewPet(PostCreateNewPetRequest newPet) {
        return given().body(newPet).header("Content-Type", "application/json")
                .when().post(ENDPOINTS.getProperty("GET_PET_BY_ID"))
                .then().log().all().extract().response().as(PetResponse.class);
    }

    protected void validateResponseData(PetResponse response) {
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
