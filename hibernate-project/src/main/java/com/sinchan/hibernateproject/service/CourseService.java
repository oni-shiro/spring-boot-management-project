package com.sinchan.hibernateproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinchan.hibernateproject.entity.CourseEntity;
import com.sinchan.hibernateproject.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepo;

	public CourseEntity getCourseById(int id) {
		
		
		CourseEntity course = courseRepo.findById(id);
		System.err.println(course.toString());
		return course;
	}
	
}
