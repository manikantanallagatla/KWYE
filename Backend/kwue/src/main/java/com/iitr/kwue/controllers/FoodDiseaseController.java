package com.iitr.kwue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iitr.kwue.entities.FoodDisease;
import com.iitr.kwue.entities.User;
import com.iitr.kwue.repository.FoodDiseaseRepository;
import com.iitr.kwue.repository.UserRepository;

@RestController
@RequestMapping("/fooddisease")
public class FoodDiseaseController {

	@Autowired
	private FoodDiseaseRepository foodDiseaseRepository;
	
	@PostMapping("/addFoodDiseaseMap")
	public void addFoodDiseaseMap(@RequestBody FoodDisease f) {
		foodDiseaseRepository.save(f);
		//userServiceImpl.signUpUser(u);
	//	return u;
	}
	
	@PostMapping("/removeFoodDiseaseMap")
	public void removeFoodDiseaseMap(@RequestBody FoodDisease f) {
		foodDiseaseRepository.delete(f);
		//userServiceImpl.signUpUser(u);
	//	return u;
	}
}
