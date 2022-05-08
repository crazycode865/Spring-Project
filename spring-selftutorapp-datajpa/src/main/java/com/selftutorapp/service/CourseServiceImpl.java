package com.selftutorapp.service;

import com.selftutorapp.model.Course;
import com.selftutorapp.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    ICourseRepository iCourseRepository;

    @Override
    public void addCourse(Course course) {
        iCourseRepository.save(course);
    }

    @Override
    public void deleteCourse(int courseId) {
        iCourseRepository.deleteById(courseId);
    }

    @Override
    public void updateCourse(Course course) {

    }

    @Override
    public Course getById(int courseId) {
        return null;
    }

//    @Override
//    public List<Course> getByCategory(String category) {
//        return iCourseRepository.getByCategory(category);
//    }

//    @Override
//    public List<Course> getByLanguage(String language) {
//        return null;
//    }
//
//    @Override
//    public List<Course> getByCategoryLevel(String category, String level) {
//        return null;
//    }
//
//    @Override
//    public List<Course> getByTopic(String topic) {
//        return null;
//    }
//
//    @Override
//    public List<Course> getBySubCategory(String subCategory) {
//        return null;
//    }
//
//    @Override
//    public List<Course> getByCategorySub(String category, String subCategory) {
//        return null;
//    }
//
//    @Override
//    public List<Course> getBySubCategoryLevel(String subcategory, String level) {
//        return null;
//    }
//
//    @Override
//    public List<Course> getByTrainer(String trainerName) {
//        return null;
//    }
//
//    @Override
//    public List<Course> getByLanguageCategory(String language, String category) {
//        return null;
//    }
//
//    @Override
//    public List<Course> getByTopicFeatures(String topic) {
//        return null;
//    }
//
//    @Override
//    public List<Course> getByLanguageRatings(String language, double ratings) {
//        return null;
//    }
//
//    @Override
//    public List<Course> getByTopicLevel(String topic, String level) {
//        return null;
//    }
}
