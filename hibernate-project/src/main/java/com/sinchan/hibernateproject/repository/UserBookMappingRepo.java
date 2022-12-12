package com.sinchan.hibernateproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sinchan.hibernateproject.entity.UserBookMapping;


@Repository
public interface UserBookMappingRepo extends JpaRepository<UserBookMapping,Integer> {
    
    

}
