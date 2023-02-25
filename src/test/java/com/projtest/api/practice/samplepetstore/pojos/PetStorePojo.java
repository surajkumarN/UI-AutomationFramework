package com.projtest.api.practice.samplepetstore.pojos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//@JsonIgnoreProperties(value = {"status"})
public class PetStorePojo {

    public int id;
    public Category category;
    public String name;
    public String[] photoUrls;
    public Tags[] tags;
    public String status;
}
