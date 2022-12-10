package com.sinchan.hibernateproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinchan.hibernateproject.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByUserId(Integer userId);

    Optional<User> findByUserName(String userName);

}
