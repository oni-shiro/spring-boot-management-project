package com.sinchan.hibernateproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinchan.hibernateproject.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

    // Optional<User> findByName(String userName);

}
