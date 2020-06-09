package com.iitr.kwue.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iitr.kwue.entities.User;
import com.iitr.kwue.repository.UserRepository;
import com.iitr.kwue.service.impl.UserServiceImpl;
import com.sun.istack.FinalArrayList;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/adduser")
	public User signUpUser(@RequestBody User u) {
		userServiceImpl.signUpUser(u);
		return u;
	}
	
	@GetMapping("/generateOtp")
	public void getOtp(final String phoneNo) {
		userServiceImpl.generateOtp(phoneNo);
	}
	
	@GetMapping("/verifyotp")
	public Boolean verifyOtp(final String phoneNo, final String otp) {
		return userServiceImpl.verifyOtp(phoneNo,otp);
	}
	
	@PutMapping("/updateuser")
	public  Optional<User> updateUser(User u) {
		 userRepository.save(u);
		 Optional<User> user=userRepository.findById(u.phone_no);
		 return user;
	}
	
	//to-be-implemented
	@GetMapping("/verifytoken")
	public boolean verifyToken(String apiKey,String phoneNo) {
		return userServiceImpl.verifyToken(apiKey,phoneNo);
	}
	
	//extra
	@GetMapping("/all")
	public List<User> getAllStudents(){
		return userRepository.findAll();
	}
	
	//extra
	  @GetMapping(value = "/{id}")
	  public Optional<User> searchUserById(@PathVariable("id") String id) {
	    return userRepository.findById(id);
	  }
	
	
	//extra
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteUser(@PathVariable String id) {
		userRepository.deleteById(id);
	  }
	
}
