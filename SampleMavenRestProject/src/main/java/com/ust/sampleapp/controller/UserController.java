package com.ust.sampleapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.sampleapp.exception.UserNotFoundException;
import com.ust.sampleapp.pojo.User;

@RestController	
public class UserController {
	
	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

//	@RequestMapping(value = "/getUser", method = RequestMethod.GET, produces = "application/json", headers = "Accept=application/json")
//	public @ResponseBody User getUser(@RequestParam("userid") int id) throws UserNotFoundException {
//		System.out.println("Inside user Controller");
//		User user = userService.getUser(id);
//		return user;
//	}
	
	@RequestMapping(value = "/userById", method = RequestMethod.GET)
	public @ResponseBody User getUser(@RequestParam(value = "id") Long userid)  {
		System.out.println("Inside user Controller----------------------------------------------"+userid);
		User user = userService.getUser(userid);
		return user;
	}
	
	 @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody List<User> getCountries() {
		 System.out.println("Inside user controller to get users"+userService);
		 List<User> users = userService.getUsers();
		 return users;
	 }
	
	 @RequestMapping(value = "/adduser", method = RequestMethod.POST, produces = "application/json", headers = "Accept=application/json")
	 public @ResponseBody User addCountry(@RequestBody User user) {
		 System.err.println("Inside add user"+user);
		 return userService.addUser(user);
	 }
	 
	 @RequestMapping(value = "/updateuser", method = RequestMethod.PUT, produces = "application/json", headers = "Accept=application/json")
	 public @ResponseBody User updateCountry(@RequestBody User user) {
		 System.err.println("Inside Update user"+user);
		 return userService.updateUser(user);
	 }
}
