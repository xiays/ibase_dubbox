package com.ibase.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "user")
public class UserInfo implements Serializable {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    private String username;

    private String password;

 
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}