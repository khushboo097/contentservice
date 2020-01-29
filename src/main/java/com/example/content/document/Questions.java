package com.example.content.document;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document
public class Questions {

    @Id
    private String questionId;
    private String questionFormat;
    private List<String> questionAncChoices;
    private String answers;
    private String difficultyLevel;
    private String categoryId;
    private String urlAttachment;
    private Integer QuestionType;

}