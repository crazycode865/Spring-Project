package com.selftutorapp.service;

import com.selftutorapp.model.Trainer;

public interface ITrainerService {

    void addTrainer(Trainer Trainer);
    void updateTrainer(Trainer Trainer);
    void deleteTrainer(int trainerId);
    Trainer getById(int TrainerId);

//    List<Trainer> getByCategory(String category);
//    List<Trainer> getBySubCategoryTopic(String subCategory,String topic);
//    List<Trainer> getByCategoryLevel(String category,String level);
//
//    List<Trainer> getByLanguage(String language);
//    List<Trainer> getByLanguageCategory(String language, String category);
//    List<Trainer> getByLanguageRatings(String language, double ratings);
//
//    List<Trainer> getByTopic(String topic);
//    List<Trainer> getByTopicLanguage(String topic,String language);
//     List<Trainer> getByTopicFeatures(String topic);
//    List<Trainer> getByTopicLevel(String topic ,String level);

//    List<Trainer> getByTrainer(String trainerName);


}
