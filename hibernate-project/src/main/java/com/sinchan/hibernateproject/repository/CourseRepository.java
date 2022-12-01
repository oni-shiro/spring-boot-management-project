package com.sinchan.hibernateproject.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinchan.hibernateproject.entity.CourseEntity;

@Repository
public class CourseRepository {
	
	@Autowired
	EntityManager em;
	public CourseEntity findById(int id) {
		System.err.println("+=======++"+ id);
		CourseEntity course =  em.find(CourseEntity.class,id);
		System.err.println(course.toString());
		return course;
		
	}
		
}
