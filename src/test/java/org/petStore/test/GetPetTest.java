package org.petStore.test;

import org.junit.jupiter.api.Test;
import org.petStore.pet.steps.GetPetSteps;

public class GetPetTest extends GetPetSteps {

    @Test
    public void getPetByIdTest() {
        getPetByIdStep(399);
    }
}
