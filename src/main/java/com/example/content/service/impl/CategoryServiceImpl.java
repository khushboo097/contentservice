package com.example.content.service.impl;

import com.example.content.document.Categories;
import com.example.content.repository.CategoriesRepository;
import com.example.content.service.CategoryService;
import com.example.content.service.QuestionService;
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
}
