package com.example.content.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class QuestionsDTO {

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
