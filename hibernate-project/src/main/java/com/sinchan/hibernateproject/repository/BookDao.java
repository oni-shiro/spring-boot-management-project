package com.sinchan.hibernateproject.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sinchan.hibernateproject.entity.Book;

public interface BookDao extends JpaRepository<Book,Integer> {
   
}
