package com.example.content.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionsDTO {

    private String questionId;
    private String questionFormat;
    private List<String> questionAncChoices;
    private String answers;
    private String difficultyLevel;
    private String categoryId;
    private String urlAttachment;
    private Integer QuestionType;
}
