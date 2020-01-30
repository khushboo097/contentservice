package com.example.content.service;

import com.example.content.document.Questions;
import com.example.content.dto.QuestionRatingDTO;
import com.example.content.dto.QuestionsDTO;
import com.example.content.dto.StaticQuestionsDTO;
import com.example.content.dto.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;


public interface QuestionService {

    Optional<Questions> getQuestionById(String QuestionId);
    ArrayList<Questions> getQuestionByCategory(String categoryId);
    void save(QuestionsDTO questionsDTO);
    ArrayList<Questions> getStaticQuestions(StaticQuestionsDTO staticQuestionsDTO);
    void setQuestionRating(QuestionRatingDTO questionRatingDTO);
}
