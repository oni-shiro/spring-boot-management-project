package com.sinchan.hibernateproject.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinchan.hibernateproject.entity.User;
import com.sinchan.hibernateproject.payload.UserDto;
import com.sinchan.hibernateproject.repository.UserRepo;
import com.sinchan.hibernateproject.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		User createdUser = this.userRepo.save(user);
		return this.modelMapper.map(createdUser, UserDto.class);
	}

//	@Override
//	public UserDto updateUser(Integer userId, UserDto userDto) {
//		User foundUser = this.userRepo.findById(userId)
//				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
//		foundUser.setUserName(userDto.getUserName());
//		foundUser.setUserRole(userDto.getUserRole());
//		User savedUser = this.userRepo.save(foundUser);
//		return this.modelMapper.map(savedUser, UserDto.class);
//	}
//
//	@Override
//	public void deleteUser(Integer userId) {
//		User user = this.userRepo.findById(userId)
//				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
//		this.userRepo.delete(user);
//
//	}
//
//	@Override
//	public UserDto getById(Integer userId) {
//		User user = this.userRepo.findById(userId)
//				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
//		return this.modelMapper.map(user, UserDto.class);
//	}
//
//	@Override
//	public UserDto getByName(String userName) {
//		User user = this.userRepo.findByName(userName)
//				.orElseThrow(() -> new ResourceNotFoundException("User", "userName", userName));
//		return this.modelMapper.map(user, UserDto.class);
//	}

}
