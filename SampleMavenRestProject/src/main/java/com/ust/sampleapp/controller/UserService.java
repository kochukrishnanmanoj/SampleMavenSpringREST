package com.ust.sampleapp.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ust.sampleapp.pojo.User;

@Service("userService")
public interface UserService {

	public User getUser(int id) ;
	
	public ArrayList<User> getUsers();
	
	public void updateUser(Long id);
	
	public void addUser(User user);
	
}
