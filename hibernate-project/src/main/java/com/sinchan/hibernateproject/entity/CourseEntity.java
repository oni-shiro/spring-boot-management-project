package com.sinchan.hibernateproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Courses")
public class CourseEntity {
	@Id
	@GeneratedValue
	@Column(name ="COURSE_ID")
	private int id;
	@Column(name = "COURSE_NAME")
	private String name;
	public CourseEntity() {
		
	}
	//with out id 
	public CourseEntity(String name) {
		super();
		this.name = name;
	}
	
	
	public CourseEntity(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "CourseEntity [id=" + id + ", name=" + name + "]";
	}
	
	
	
	

}
