package com.example.content.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class Categories {


    @Id
    private Integer categoryId;
    private String categoryName;

}
