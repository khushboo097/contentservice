package com.example.content.service.impl;

import com.example.content.document.Questions;
import com.example.content.dto.QuestionRatingDTO;
import com.example.content.dto.QuestionsDTO;
import com.example.content.dto.StaticQuestionsDTO;
import com.example.content.dto.Status;
import com.example.content.repository.QuestionsRepository;
import com.example.content.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {


    @Autowired
    QuestionsRepository questionsRepository;

    @Override
    public Optional<Questions> getQuestionById(String QuestionId) {
        System.out.println("==================================in service");
        Optional<Questions> questions = questionsRepository.findById(QuestionId);
//        Questions ques = new Questions();
//        if (questions.isPresent()) {
//            BeanUtils.copyProperties(questions,ques);
//            return ques;
//        }
//        return null;
        return questions;
    }

    @Override
    public ArrayList<Questions> getQuestionByCategory(String categoryId) {

        Iterable<Questions> allQuestions = questionsRepository.findAll();
        ArrayList<Questions> questionsList = new ArrayList<Questions>();
        for(Questions questions: allQuestions)
        {
            if(questions.getCategoryId().equals(categoryId))
            {
                questionsList.add(questions);
            }
        }
        return questionsList;
    }

    @Override
    public void save(QuestionsDTO questionsDTO)
    {
        Questions questions = new Questions();
        BeanUtils.copyProperties(questionsDTO,questions);
        questionsRepository.save(questions);
    }

    public ArrayList<Questions> getStaticQuestions(StaticQuestionsDTO staticQuestionsDTO){

        ArrayList<Questions> categoryQuesList = getQuestionByCategory(staticQuestionsDTO.getCategoryId());
        ArrayList<Questions> resultList = new ArrayList<>();
        ArrayList<String> qid = staticQuestionsDTO.getQuestionIds();
        for(Questions ques: categoryQuesList)
        {
            for(String id: qid)
            if(ques.getQuestionId().equals(id))
            {
                resultList.add(ques);
            }
        }
        return resultList;
    }

    @Override
    public void setQuestionRating(QuestionRatingDTO questionRatingDTO){

        Optional<Questions> question = getQuestionById(questionRatingDTO.getQuestionId());
        Questions ques = question.get();
        if(question.isPresent()){
            ques.setDifficultyLevel(questionRatingDTO.getDifficultyLevel());
        }
        questionsRepository.save(ques);

    }
}
