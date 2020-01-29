package com.example.content.controller;


import com.example.content.document.Categories;
import com.example.content.document.Questions;
import com.example.content.dto.CategoriesDTO;
import com.example.content.dto.QuestionsDTO;
import com.example.content.service.CategoryService;
import com.example.content.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
        return new ResponseEntity<ArrayList<CategoriesDTO>>(categoriesDTOS,HttpStatus.OK);
    }

    @GetMapping("/getQuestionById/{id}")
    public ResponseEntity<QuestionsDTO> getQuestionById(@PathVariable("id") String QuestionId) {

        final Questions questionById = questionService.getQuestionById(QuestionId);
        QuestionsDTO questionByIdDTO = new QuestionsDTO();
        BeanUtils.copyProperties(questionById,questionByIdDTO);
        return new ResponseEntity<QuestionsDTO>(questionByIdDTO,HttpStatus.OK);

    }

    @GetMapping("/getQuestionsByCategory/{categoryId}")
    public ResponseEntity<ArrayList<QuestionsDTO>> getQuestionByCategory(@PathVariable("categoryId") Integer categoryId){
        ArrayList<QuestionsDTO> questionsDTOS = new ArrayList<>();
        Iterable<Questions> questions = questionService.getQuestionByCategory(categoryId);
        for (Questions question : questions) {
            QuestionsDTO questionsDTO = new QuestionsDTO();
            BeanUtils.copyProperties(question,questionsDTO);
            questionsDTOS.add(questionsDTO);
        }
        return new ResponseEntity<ArrayList<QuestionsDTO>>(questionsDTOS,HttpStatus.OK);

    }



}
