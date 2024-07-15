package org.petStore.test.pet;

import org.junit.jupiter.api.Test;
import org.petStore.pet.pojo.response.PetResponse;
import org.petStore.pet.steps.GetPetSteps;

public class GetPetTest extends GetPetSteps {

    @Test
    public void getPetByIdTest() {
        PetResponse petResponse = getPetByIdStep(968968112);
        validateResponseData(petResponse);
    }
}
