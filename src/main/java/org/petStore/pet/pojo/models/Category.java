package org.petStore.pet.pojo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {

    @SerializedName("id")
    private Integer id = null;
    @SerializedName("name")
    private String name = null;
}
