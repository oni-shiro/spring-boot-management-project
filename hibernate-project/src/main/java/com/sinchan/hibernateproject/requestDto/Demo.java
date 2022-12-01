package com.sinchan.hibernateproject.requestDto;

public class Demo {
	public long a;
	public String name;
	public Demo() {
	
	}
	public Demo(long a, String name) {
		super();
		this.a = a;
		this.name = name;
	}
	public long getA() {
		return a;
	}
	public void setA(long a) {
		this.a = a;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Demo [a=" + a + ", name=" + name + "]";
	}
	
	
	
	
}
