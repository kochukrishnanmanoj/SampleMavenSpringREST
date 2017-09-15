package com.ust.sampleapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.sampleapp.pojo.User;

@RestController	
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/getUser", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody User getUser(@RequestParam("userid") int id) {
		System.out.println("Inside user Controller");
		User user = userService.getUser(id);
		return user;
	}
	
	 @RequestMapping(value = "/users", method = RequestMethod.GET, headers = "Accept=application/json", produces = "application/json")
	 public @ResponseBody List<User> getCountries() {
		 List<User> users = userService.getUsers();
		 return users;
	 }
	
	 @RequestMapping(value = "/adduser", method = RequestMethod.POST, produces = "application/json")
	 public @ResponseBody User addCountry(@RequestBody User user) {
		 System.err.println("Inside add user"+user);
		 return userService.addUser(user);
	 }
	 
	 @RequestMapping(value = "/updateuser", method = RequestMethod.PUT, produces = "application/json")
	 public @ResponseBody User updateCountry(@RequestBody User user) {
		 System.err.println("Inside Update user"+user);
		 return userService.updateUser(user);
	 }
}
