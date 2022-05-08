package com.movieapp.repository;

import com.movieapp.model.JWTUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JWTUserRepository extends JpaRepository<JWTUser,Integer> {
    JWTUser findByUsername(String username);
}
