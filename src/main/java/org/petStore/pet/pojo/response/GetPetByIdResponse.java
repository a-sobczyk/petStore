package org.petStore.pet.pojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.petStore.pet.pojo.models.Category;
import org.petStore.pet.pojo.models.Tags;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetPetByIdResponse {

    @SerializedName("id")
    private Integer id = null;
    @SerializedName("category")
    private Category category = null;
    @SerializedName("name")
    private String name = null;
    @SerializedName("photoUrls")
    private List<String> photoUrls = null;
    @SerializedName("tags")
    private List<Tags> tags = null;
    @SerializedName("status")
    private String status = null;
}
