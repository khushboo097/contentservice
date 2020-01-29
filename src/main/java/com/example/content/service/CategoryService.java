package com.example.content.service;

import com.example.content.document.Categories;
import com.example.content.dto.CategoriesDTO;
import com.example.content.dto.QuestionsDTO;

import java.util.ArrayList;

public interface CategoryService {

    Iterable<Categories> getAllCategories();

}
