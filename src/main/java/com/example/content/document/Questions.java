package com.example.content.document;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Document(collection = "questions")
public class Questions {

    @Id
    private String questionId;
    private String questionFormat;
    private String questionText;
    private Map<String,String> options;
    private String answers;
    private String difficultyLevel;
    private String categoryId;
    private String urlAttachment;
    private Integer questionType;


}