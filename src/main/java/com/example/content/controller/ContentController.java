package com.example.content.controller;


import com.example.content.document.Categories;
import com.example.content.document.Questions;
import com.example.content.dto.*;
import com.example.content.service.CategoryService;
import com.example.content.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/contentservice")
@CrossOrigin(origins = "*")
public class ContentController {

    @Autowired
    QuestionService questionService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/getCategories")
    public ResponseEntity<ArrayList<CategoriesDTO>> getAllCategories() {

        ArrayList<CategoriesDTO> categoriesDTOS = new ArrayList<>();
        Iterable<Categories> categories = categoryService.getAllCategories();
        for (Categories category : categories) {
            CategoriesDTO categoriesDTO = new CategoriesDTO();
            BeanUtils.copyProperties(category, categoriesDTO);
            categoriesDTOS.add(categoriesDTO);
        }
        return new ResponseEntity<ArrayList<CategoriesDTO>>(categoriesDTOS, HttpStatus.OK);
    }

    @PostMapping("/addCategory")
    public ResponseEntity<Status> addCategory(@RequestBody CategoriesDTO categoriesDTO)
    {
        categoryService.save(categoriesDTO);
        Status status = new Status();
        status.setStatus(true);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/getQuestionById/{id}")
    public ResponseEntity<QuestionsDTO> getQuestionById(@PathVariable("id") String QuestionId) {
        System.out.println("====================================");
        Optional<Questions> questionById = questionService.getQuestionById(QuestionId);
        QuestionsDTO questionByIdDTO = new QuestionsDTO();

        BeanUtils.copyProperties(questionById.get(), questionByIdDTO);
        return new ResponseEntity<QuestionsDTO>(questionByIdDTO, HttpStatus.OK);

    }

    @GetMapping("/getQuestionsByCategory/{categoryId}")
    public ResponseEntity<ArrayList<QuestionsDTO>> getQuestionByCategory(@PathVariable("categoryId") String categoryId) {
        System.out.println("========================");
        ArrayList<QuestionsDTO> questionsDTOS = new ArrayList<>();
        Iterable<Questions> questions = questionService.getQuestionByCategory(categoryId);
        for (Questions question : questions) {
            QuestionsDTO questionsDTO = new QuestionsDTO();
            BeanUtils.copyProperties(question, questionsDTO);
            questionsDTOS.add(questionsDTO);
        }
        return new ResponseEntity<ArrayList<QuestionsDTO>>(questionsDTOS, HttpStatus.OK);

    }

    @PostMapping("/addQuestion")
    public ResponseEntity<?> addQuestion(@RequestBody QuestionsDTO questionsDTO) {

        questionService.save(questionsDTO);
        Status status = new Status();
        status.setStatus(true);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping("/Contest/getQuestions")
    public ResponseEntity<ArrayList<QuestionsDTO>> getStaticQuestions(@RequestBody StaticQuestionsDTO staticQuestionsDTO){

        ArrayList<Questions> questions = questionService.getStaticQuestions(staticQuestionsDTO);
        ArrayList<QuestionsDTO> questionsDTOS = new ArrayList<>();
        for(Questions ques : questions)
        {
            QuestionsDTO questionsDTO = new QuestionsDTO();
            BeanUtils.copyProperties(ques, questionsDTO);
            questionsDTOS.add(questionsDTO);
        }
        return new ResponseEntity<ArrayList<QuestionsDTO>>(questionsDTOS,HttpStatus.OK);
    }

    @PutMapping("/setQuestionRating")
    public ResponseEntity<Status> setQuestionRating(@RequestBody QuestionRatingDTO questionRatingDTO) {

        questionService.setQuestionRating(questionRatingDTO);
        Status status = new Status();
        status.setStatus(true);
        return new ResponseEntity<>(status, HttpStatus.OK);

    }

}
