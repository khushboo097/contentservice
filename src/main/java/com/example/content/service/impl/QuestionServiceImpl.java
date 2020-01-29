package com.example.content.service.impl;

import com.example.content.document.Questions;
import com.example.content.dto.QuestionsDTO;
import com.example.content.repository.QuestionsRepository;
import com.example.content.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {


    @Autowired
    QuestionsRepository questionsRepository;

    @Override
    public Questions getQuestionById(String QuestionId) {
        Optional<Questions> questions = questionsRepository.findById(QuestionId);
        Questions ques = new Questions();
        if (questions.isPresent()) {
            BeanUtils.copyProperties(questions,ques);
            return ques;
        }
        return null;
    }

    @Override
    public ArrayList<Questions> getQuestionByCategory(Integer categoryId) {
        /*
        Iterable<Employee> allEmployees = employeeRepository.findAll();
        Integer employeesInDept=0;
        for(Employee employee: allEmployees)
        {
            if(employee.getDeptid()==id)
            {
                employeesInDept++;
            }
        }
        return employeesInDept;
         */
//        Iterable<Questions> allQuestions = questionsRepository.findAll();
//        for(Questions questions: allQuestions)
//        {
//            if(questions.getCategoryId()==categoryId)
//            {
//
//            }
//        }
    }


}
