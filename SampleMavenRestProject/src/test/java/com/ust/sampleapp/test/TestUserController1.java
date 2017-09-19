package com.ust.sampleapp.test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ust.sampleapp.controller.UserController;
import com.ust.sampleapp.controller.UserService;
import com.ust.sampleapp.exception.UserNotFoundException;
import com.ust.sampleapp.pojo.User;

public class TestUserController1 {

	 	private MockMvc mockMvc;

	    @Mock
	    private UserService userService;
	    
	    @Before
	    public void init(){
	        MockitoAnnotations.initMocks(this);
	        
	        mockMvc = MockMvcBuilders
	                .standaloneSetup(new UserController(userService))
	                .build();
	    }

	    // =========================================== Get All Users ==========================================

	    @Test
	    public void test_getUsers() throws Exception {
	    	List<User> users = Arrays.asList(
	                new User(1L, "Daenerys Targaryen",20,"F",null),
	                new User(2L, "John Snow",33,"M",null));

	        when(userService.getUsers()).thenReturn(users);
	        mockMvc.perform(get("/users"))	        		
	                .andExpect(status().isOk())
	                .andDo(MockMvcResultHandlers.print())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
	                .andExpect(jsonPath("$", hasSize(2)))
	                .andExpect(jsonPath("$[0].id", is(1)))
	                .andExpect(jsonPath("$.[0].name").value("Daenerys Targaryen"))
	                .andExpect(jsonPath("$[1].id", is(2)))
	                .andExpect(jsonPath("$.[1].name", is("John Snow")));

	        verify(userService, times(1)).getUsers();
	        verifyNoMoreInteractions(userService);
	    }
	    
	    @Test
	    public void test_getUserReturnsUser() throws Exception {
	    	User user = new User(1L, "Daenerys Targaryen",20,"F",null);
	    	when(userService.getUser(1L)).thenReturn(user);
	    	
	    	 mockMvc.perform(get("/userById").param("id", "1"))
	    	 .andDo(MockMvcResultHandlers.print())
	    	 .andExpect(status().isOk())
	    	 .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
             .andExpect(jsonPath("$.id", is(1)))
             .andExpect(jsonPath("$.name").value("Daenerys Targaryen"));

	    	 verify(userService, times(1)).getUser(1L);
	    	 verifyNoMoreInteractions(userService);
	    }
	    
//	    @Test
//	    public void test_getUserThrowsException() throws Exception {
//	    	when(userService.getUser(1)).thenThrow(new UserNotFoundException(1));
//	    	
//	    	 mockMvc.perform(get("/user/getUser/1"))
//             .andExpect(status().isNotFound());
//
//	    	 verify(userService, times(1)).getUser(1);
//	    	 verifyNoMoreInteractions(userService);
//	    }
	    
	   


}