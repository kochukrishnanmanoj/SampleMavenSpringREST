package com.ust.sampleapp.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ust.sampleapp.pojo.User;

@Component
public class UserServiceImpl implements UserService{
	
	private static List<User> users = createUsers();
	
	static List<User> createUsers() {
		System.out.println("Inside create users............");
		users = new ArrayList<>();
		User u = new User(1,"Tring",33,"M",LocalDate.now());
		User u1 = new User(2, "Song",31,"M",LocalDate.now());
		users.add(u);
		users.add(u1);
		return users;
	}

	public User getUser(int id) {
		
		return users
				.stream()
				.filter(user -> id == user.getId())
				.findAny()
				.orElse(null);
	}
	
	public ArrayList<User> getUsers() {
		return null;
	}
	
	public void updateUser(Long id) {

	}
	
	public void addUser(User user) {
		
	}
	
}
