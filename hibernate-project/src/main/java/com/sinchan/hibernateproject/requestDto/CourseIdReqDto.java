package com.sinchan.hibernateproject.requestDto;

public class CourseIdReqDto {
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CourseIdReqDto(int id) {
		super();
		this.id = id;
	}

	public CourseIdReqDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CourseIdReqDto [id=" + id + "]";
	}
	
}
