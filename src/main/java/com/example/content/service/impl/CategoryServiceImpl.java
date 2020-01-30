package com.example.content.service.impl;

import com.example.content.document.Categories;
import com.example.content.document.Questions;
import com.example.content.dto.CategoriesDTO;
import com.example.content.dto.QuestionsDTO;
import com.example.content.repository.CategoriesRepository;
import com.example.content.service.CategoryService;
import com.example.content.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoriesRepository categoriesRepository;

    @Override
    public Iterable<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }
    @Override
    public void save(CategoriesDTO categoriesDTO)
    {
        Categories categories = new Categories();
        BeanUtils.copyProperties(categoriesDTO,categories);
        categoriesRepository.save(categories);
    }
}
