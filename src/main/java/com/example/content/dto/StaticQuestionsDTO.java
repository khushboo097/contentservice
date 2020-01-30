package com.example.content.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class StaticQuestionsDTO {

    private String categoryId;
    private ArrayList<String> questionIds;
}
