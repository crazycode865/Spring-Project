package com.selftutorapp.service;

import com.selftutorapp.model.Category;
import com.selftutorapp.model.Category;

import java.util.List;

public interface ICategoryService {
    Category addCategory(Category Category);
    void deleteCategory(int categoryId);
    void updateCategory(Category Category);

    Category getById(int CategoryId);

    List<Category> getByLanguage(String language);

    List<Category> getByTopic(String topic);

}
