package com.ust.sampleapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
}
