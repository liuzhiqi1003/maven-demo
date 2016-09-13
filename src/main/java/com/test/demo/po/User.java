package com.test.demo.po;

import javax.validation.constraints.Size;

public class User {

	private Integer id;
	
	@Size(min=3,max=6,message="{username.length.error}")
	private String username;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + "]";
	}
	
	
}
