package com.selftutorapp.service;

import com.selftutorapp.model.Course;

import java.util.List;

public interface ICourseService {
    void  addCourse(Course course);
    void deleteCourse(int courseId);
    void updateCourse(Course course);

    Course getById(int courseId);

//    List<Course> getByCategory(String category);
//    List<Course> getByLanguage(String language);
//    List<Course> getByCategoryLevel(String category, String level);
//    List<Course> getByTopic(String topic);
//    List<Course> getBySubCategory(String subCategory);
//    List<Course> getByCategorySub(String category,String subCategory);
//    List<Course> getBySubCategoryLevel(String subcategory, String level);
//    List<Course> getByTrainer(String trainerName);
//    List<Course> getByLanguageCategory(String language, String category);
//    List<Course> getByTopicFeatures(String topic);
//    List<Course> getByLanguageRatings(String language, double ratings);
//    List<Course> getByTopicLevel(String topic ,String level);

}
