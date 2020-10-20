package com.example.springgbtest.repository;

import com.example.springgbtest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByAgeBetween(int minAge, int maxAge);

}
