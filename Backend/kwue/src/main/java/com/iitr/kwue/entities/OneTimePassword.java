package com.iitr.kwue.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.iitr.kwue.Constants.Constants.TableConstants.OneTimePasswordConstants;

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
	@Field(name=OneTimePasswordConstants.PHONE_NO)
	public String phone_no;
	
	@Field(name = OneTimePasswordConstants.OTP_NUMBER)
	public String otpNumber;
	
	@Field(name = OneTimePasswordConstants.TIME_STAMP)
	public long timeStamp;
	
}
