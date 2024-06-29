package org.petStore.test;

import org.junit.jupiter.api.Test;
import org.petStore.pet.pojo.response.GetPetByIdResponse;
import org.petStore.pet.steps.GetPetSteps;

public class GetPetTest extends GetPetSteps {

    @Test
    public void getPetByIdTest() {
        GetPetByIdResponse getPetByIdResponse = getPetByIdStep(968968112);
        validateResponseData(getPetByIdResponse);
    }
}
