package com.sinchan.hibernateproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinchan.hibernateproject.constants.StringConstants;
import com.sinchan.hibernateproject.payload.ApiResponse;
import com.sinchan.hibernateproject.payload.UserDto;
import com.sinchan.hibernateproject.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// create a new user

	@PostMapping("/addUser")
	public UserDto createUser(@RequestBody UserDto userDto) {
		UserDto createdUser = this.userService.createUser(userDto);
		return createdUser;
	}

	// update user

	@PutMapping("/updateUser/{userId}")
	public UserDto updateUser(@PathVariable Integer userId, @RequestBody UserDto userDto) {
		return this.userService.updateUser(userId, userDto);
	}

	// delete user

	@DeleteMapping("/deleteUser/{userId}")
	public ApiResponse deleteUser(@PathVariable Integer userId) {
		this.userService.deleteUser(userId);
		return new ApiResponse("User Id - " + userId.toString() + StringConstants.DELETE_MESSAGE, "200 Ok");
	}

	// find user by Id

	@GetMapping("/findUser/id/{userId}")
	public UserDto getUserbyId(@PathVariable Integer userId) {
		UserDto foundedUserDto = this.userService.getById(userId);
		return foundedUserDto;
	}

	// find by userName

	@GetMapping("/findUser/name/{userName}")
	public UserDto getByName(@PathVariable String userName) {
		return this.userService.getByName(userName);
	}

	// find all users

	@GetMapping("/findUser/")
	public List<UserDto> getAllUsers() {
		return this.userService.getAllUsers();
	}

}
