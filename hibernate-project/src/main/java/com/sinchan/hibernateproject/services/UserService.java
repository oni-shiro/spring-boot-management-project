package com.sinchan.hibernateproject.services;

import java.util.List;

import com.sinchan.hibernateproject.payload.UserDto;

public interface UserService {

	// create
	UserDto createUser(UserDto userDto);

	// update
	UserDto updateUser(Integer userId, UserDto userDto);

	// delete
	void deleteUser(Integer userId);

	// getbyId

	UserDto getById(Integer userId);

	// getbyName
	UserDto getByName(String userName);

	// get all users

	List<UserDto> getAllUsers();
}
