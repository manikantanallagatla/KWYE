package com.iitr.kwue.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Document()
public class OneTimePassword {
	@Id
	@Field(name="phone_no")
	public String phone_no;
	
	@Field(name = "otpNumber")
	public String otpNumber;
	
	@Field(name = "timeStamp")
	public long timeStamp;
	
}
