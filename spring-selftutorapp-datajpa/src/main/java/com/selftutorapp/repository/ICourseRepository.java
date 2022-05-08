package com.selftutorapp.repository;

import com.selftutorapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICourseRepository extends JpaRepository<Course,Integer> {

   // List<Course> getByCategory(String category);
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
