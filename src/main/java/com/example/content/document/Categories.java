package com.example.content.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "category")
public class Categories {


    @Id
    private String categoryId;
    private String categoryName;

}
