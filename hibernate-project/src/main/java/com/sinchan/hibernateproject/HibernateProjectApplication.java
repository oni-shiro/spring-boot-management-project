package com.sinchan.hibernateproject;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
//import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableProcessApplication
@ComponentScan(basePackages = "com.sinchan.hibernateproject")
public class HibernateProjectApplication {
	// http://localhost:8080/camunda/app/cockpit/default/#/processes
	// batch tutorial git
	// https://github.com/javacodingskills/SpringBatch/tree/master/06_SpringBatch_Demo1_InbuildWriter/06_SpringBatch_Demo1_InbuildWriter/spring.batch.demo1

	public static void main(String[] args) {
		SpringApplication.run(HibernateProjectApplication.class, args);
	}

}
