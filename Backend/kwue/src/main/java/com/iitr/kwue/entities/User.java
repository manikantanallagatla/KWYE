package com.iitr.kwue.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.iitr.kwue.Constants.Constants.TableConstants.UserConstants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "Users")
public class User {
	  @Id
	  @Field(name=UserConstants.PHONE_NO)
	  public String phone_no;
	  @Field(name=UserConstants.USER_NAME)
	  public String name;
	  public String email;
	  public long age;
	  public String gender;
	  public String otp;
	  public String token;
	public Object getError() {
		return phone_no;
	}
}
