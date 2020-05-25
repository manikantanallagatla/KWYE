package com.KWYE.UserAuthentication;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
class User {
	private String name;
	private String email;
	private Long phoneNo;
	
	User() {}
	
	User(String name, String email, long phoneNo){
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
	}
}
