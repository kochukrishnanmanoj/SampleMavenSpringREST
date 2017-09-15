package com.ust.sampleapp.pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4554017086897239915L;

	private int id;
	
	private String name;
	
	private Integer age;
	
	private String sex;
	
	@JsonIgnore
	private LocalDate dob;
	
	public User() {
		super();
	}

	public User(int id, String name, Integer age, String sex, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

}
