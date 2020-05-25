package com.iitr.kwue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iitr.kwue.entities.Student;
import com.iitr.kwue.entities.User;
import com.iitr.kwue.repository.StudentRepository;
import com.iitr.kwue.repository.UserRepository;
import com.iitr.kwue.service.StudentService;
import com.iitr.kwue.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void signUpUser(User u) {
		userRepository.save(u);
	}
	
	public Long generateOtp(String apiKey,String phoneNo) {
		//to be implemented
		return null;
	}

	public Boolean verifyOtp(String apiKey, String phoneNo, Long otp) {
		//to be implemented
		return null;
	}

	public boolean verifyToken(String apiKey, String phoneNo) {
		// to be implemented
		return false;
	}
	
}
