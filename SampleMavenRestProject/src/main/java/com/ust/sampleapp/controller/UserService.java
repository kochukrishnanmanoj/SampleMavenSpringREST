package com.ust.sampleapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ust.sampleapp.pojo.User;

@Service("userService")
public interface UserService {

	public User getUser(int id) ;
	
	public List<User> getUsers();
	
	public User updateUser(User user);
	
	public User addUser(User user);
	
}
