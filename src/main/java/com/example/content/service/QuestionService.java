package com.example.content.service;

import com.example.content.document.Questions;
import com.example.content.dto.QuestionsDTO;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;


public interface QuestionService {

    Questions getQuestionById(String QuestionId);
    ArrayList<Questions> getQuestionByCategory(Integer categoryId);
}
