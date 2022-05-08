package com.selftutorapp.service;

import com.selftutorapp.model.Category;
import com.selftutorapp.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public Category addCategory(Category category) {
        return iCategoryRepository.save(category);
    }

    @Override
    public void deleteCategory(int categoryId) {
        iCategoryRepository.deleteById(categoryId);
    }

    @Override
    public void updateCategory(Category Category) {

    }

    @Override
    public Category getById(int CategoryId) {
        return null;
    }

    @Override
    public List<Category> getByLanguage(String language) {
        return null;
    }

    @Override
    public List<Category> getByTopic(String topic) {
        return null;
    }
}
