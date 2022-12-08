package com.sinchan.hibernateproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinchan.hibernateproject.payload.UserDto;
import com.sinchan.hibernateproject.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public UserDto createUser(@RequestBody UserDto userDto) {
		UserDto createdUser = this.userService.createUser(userDto);
		return createdUser;
	}
}
