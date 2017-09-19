package com.ust.sampleapp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ust.sampleapp.exception.UserNotFoundException;
import com.ust.sampleapp.pojo.User;

@Component
public class UserServiceImpl implements UserService{
	
	private static List<User> users = createUsers();
	
	static List<User> createUsers() {
		System.out.println("Inside create users;;;;;;;;;;;;;;;;;;;;;;;");
		users = new ArrayList<>();
		User u = new User(1L,"Tring",33,"M",LocalDate.now());
		User u1 = new User(2L, "Song",31,"M",LocalDate.now());
		users.add(u);
		users.add(u1);
		return users;
	}

	public User getUser(Long id)  {
		System.err.println("inside get user -- "+ id);
		User user = users
				.stream()
				.filter(u -> id == u.getId())
				.findAny()
				.orElse(null);
		
			return user;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public User updateUser(User user) {
		
		User u = users
				.stream()
				.filter(u1 -> u1.getId() == user.getId())
				.findAny()
				.orElse(null);
		u.setAge(user.getAge());
		u.setDob(user.getDob());
		u.setName(user.getName());
		u.setSex(user.getSex());
		
		return u;
	}
	
	public User addUser(User user) {
		users.add(user);
		
		return user;
	}
	
}
