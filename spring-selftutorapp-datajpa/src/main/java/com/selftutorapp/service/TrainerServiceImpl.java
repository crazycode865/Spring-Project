package com.selftutorapp.service;

import com.selftutorapp.model.Trainer;
import com.selftutorapp.repository.ITrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerServiceImpl implements  ITrainerService {
    @Autowired
    ITrainerRepository iTrainerRepository;
    @Override
    public void addTrainer(Trainer trainer) {
       iTrainerRepository.save(trainer);
    }

    @Override
    public void updateTrainer(Trainer trainer) {

    }

    @Override
    public void deleteTrainer(int trainerId) {

    }

    @Override
    public Trainer getById(int trainerId) {
        return null;
    }
}
