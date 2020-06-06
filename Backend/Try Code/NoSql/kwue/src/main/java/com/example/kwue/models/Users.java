package com.example.kwue.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Users {
	  @Id
	  public ObjectId _id;
	  
	  public String name;
	  public String emailId;
	  public int age;
	  
	  // Constructors
	  public Users() {}
	  
	  public Users(ObjectId _id, String name, String emailId, int age) {
	    this._id = _id;
	    this.name = name;
	    this.emailId = emailId;
	    this.age = age;
	  }
	  
	  // ObjectId needs to be converted to string
	  public String get_id() { return _id.toHexString(); }
	  public void set_id(ObjectId _id) { this._id = _id; }
	  
	  public String getName() { return name; }
	  public void setName(String name) { this.name = name; }
	  
	  public String getEmailId() { return emailId; }
	  public void setEmailId(String emailId) { this.emailId = emailId; }
	  
	  public int getage() { return age; }
	  public void setage(int age) { this.age = age; }
}
