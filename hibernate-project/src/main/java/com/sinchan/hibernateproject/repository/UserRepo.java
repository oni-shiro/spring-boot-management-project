package com.sinchan.hibernateproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sinchan.hibernateproject.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

//	Optional<User> findByName(String userName);

}
