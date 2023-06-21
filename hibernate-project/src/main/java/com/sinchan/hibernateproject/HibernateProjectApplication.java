package com.sinchan.hibernateproject;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
//import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableProcessApplication
@ComponentScan(basePackages = "com.sinchan.hibernateproject")
public class HibernateProjectApplication implements CommandLineRunner {
	// http://localhost:8080/camunda/app/cockpit/default/#/processes
	// batch tutorial git
	// https://github.com/javacodingskills/SpringBatch/tree/master/06_SpringBatch_Demo1_InbuildWriter/06_SpringBatch_Demo1_InbuildWriter/spring.batch.demo1




	public static void main(String[] args) {
		SpringApplication.run(HibernateProjectApplication.class, args);
	}

	//just to generate Bcrypt Token
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.passwordEncoder.encode("abcd123"));
	}
}
