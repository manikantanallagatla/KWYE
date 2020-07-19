package com.iitr.kwue.service.impl;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import com.iitr.kwue.Constants.Constants;
import com.iitr.kwue.entities.OneTimePassword;
import com.iitr.kwue.entities.User;
import com.iitr.kwue.repository.UserRepository;
import com.iitr.kwue.service.UserService;

import utilities.OneTimePasswordUtil;

import com.iitr.kwue.repository.OneTimePasswordRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OneTimePasswordRepository oneTimePasswordRepository;
	
	public void signUpUser(User u) {
		userRepository.save(u);
	}
	
	public void generateOtp(final String phoneNo) {
		logger.info("Phone number 1 : " + phoneNo);
		final Random random = new Random();
		final String otpNumber = String.format("%06d", random.nextInt(1000000));
		final OneTimePassword oneTimePassword = new OneTimePassword();
		oneTimePassword.otpNumber = otpNumber;
		oneTimePassword.phone_no = phoneNo;
		oneTimePassword.timeStamp = ZonedDateTime.now(ZoneId.of(Constants.UTC_ZONE_ID)).toInstant().toEpochMilli();
		
		try {
			oneTimePasswordRepository.save(oneTimePassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Boolean verifyOtp(final String phoneNo, final String otpNumber) {
		final Optional<OneTimePassword> oneTimePassword = oneTimePasswordRepository.findById(phoneNo);
		return OneTimePasswordUtil.isValidOTP(oneTimePassword.get(), otpNumber);
	}
	
	public Boolean invalidateOTP(final String phoneNo) {
		try {
			oneTimePasswordRepository.deleteById(phoneNo);
		} catch (final Exception e) {
			// TODO: handle exception
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
		
	}

	public boolean verifyToken(String apiKey, String phoneNo) {
		// to be implemented
		return false;
	}
	
}
