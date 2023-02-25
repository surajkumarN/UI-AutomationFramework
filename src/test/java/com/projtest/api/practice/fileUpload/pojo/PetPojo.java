package com.projtest.api.practice.fileUpload.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//getters and setters also override toString
@AllArgsConstructor
@NoArgsConstructor
public class PetPojo {
    private int id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tag[] tags;
    private String status;

}
/*
{
  "id": 1,
  "category": {
    "id": 0,
    "name": "string"
  },
  "name": "dogie",
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 0,
      "name": "string"
    }
  ],
  "status": "available"
}
 */