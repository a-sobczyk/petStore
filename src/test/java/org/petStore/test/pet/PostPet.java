package org.petStore.test.pet;

import org.junit.jupiter.api.Test;
import org.petStore.pet.pojo.request.PostCreateNewPetRequest;
import org.petStore.pet.pojo.response.PetResponse;
import org.petStore.pet.steps.PostCreateNewPetSteps;

public class PostPet extends PostCreateNewPetSteps {

    @Test
    public void createNewPet() {
        PostCreateNewPetRequest newPet = prepareNewPet();
        PetResponse response = postCreateNewPet(newPet);
        validateResponseData(response);
    }
}
