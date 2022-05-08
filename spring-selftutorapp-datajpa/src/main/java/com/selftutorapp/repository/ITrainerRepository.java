package com.selftutorapp.repository;

import com.selftutorapp.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITrainerRepository extends JpaRepository<Trainer,Integer> {
}
