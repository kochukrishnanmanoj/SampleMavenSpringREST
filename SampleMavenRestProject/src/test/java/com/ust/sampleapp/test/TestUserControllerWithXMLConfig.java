package com.ust.sampleapp.test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
		"file:src/main/webapp/WEB-INF/springrest-servlet.xml",
		"file:src/main/webapp/WEB-INF/springrest-servlet-security.xml"})
public class TestUserControllerWithXMLConfig {

	private MockMvc mockMvc;
	
	@Autowired 
	private WebApplicationContext ctx;

    @Before  
    public void init() {  
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.ctx).build();
    }  
    
    @Test
    public void test_getUsers() throws Exception {
    	this.mockMvc.perform(get("/users"))	        		
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(jsonPath("$[0].id", is(1)))
        .andExpect(jsonPath("$.[0].name").value("Tring"));
    }
    
    @Test
    public void test_getUserReturnsUser() throws Exception {
    	
    	 mockMvc.perform(get("/userById").param("id", "1"))
    	 .andExpect(status().isOk())
         .andExpect(jsonPath("$.id", is(1)))
         .andExpect(jsonPath("$.name").value("Tring"));
    }
}
