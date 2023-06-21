package com.sinchan.hibernateproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinchan.hibernateproject.entity.UserBookMapping;

public interface UserBookMappingRepo extends JpaRepository<UserBookMapping, Integer> {

}
