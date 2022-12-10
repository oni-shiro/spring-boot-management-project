package com.sinchan.hibernateproject.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinchan.hibernateproject.entity.User;
import com.sinchan.hibernateproject.exceptions.DataIntegrityViolationException;
import com.sinchan.hibernateproject.exceptions.ResourceNotFoundException;
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
		User createdUser = new User();
		try {
			createdUser = this.userRepo.save(this.modelMapper.map(userDto, User.class));
		} catch (Exception e) {
			throw new DataIntegrityViolationException("User", "userName", userDto.getUserName());
		}
		return this.modelMapper.map(createdUser, UserDto.class);
	}

	@Override
	public UserDto updateUser(Integer userId, UserDto userDto) {
		User foundUser = this.userRepo.findByUserId(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		foundUser.setUserName(userDto.getUserName());
		foundUser.setUserRole(userDto.getUserRole());
		foundUser.setUserPassword(userDto.getUserPassword());

		User savedUser = new User();
		try {
			savedUser = this.userRepo.save(foundUser);

		} catch (Exception e) {
			throw new DataIntegrityViolationException("User", "user name", userDto.getUserName());
		}
		return this.modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findByUserId(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		this.userRepo.delete(user);
	}

	@Override
	public UserDto getById(Integer userId) {
		User user = this.userRepo.findByUserId(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto getByName(String userName) {
		User user = this.userRepo.findByUserName(userName)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userName",
						userName));
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> allUsers = this.userRepo.findAll();
		List<UserDto> allUserDtos = allUsers.stream().map(user -> this.modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());
		return allUserDtos;
	}

}
