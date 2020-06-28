package com.iitr.kwue.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iitr.kwue.entities.Dish;
import com.iitr.kwue.repository.DishRepository;

@RestController
@RequestMapping("/dish")
public class DishController {
	@Autowired
	private DishRepository dishRepository;
	
	@PostMapping("/createDish")
	public Dish createDish(@RequestBody String data) {
		return dishRepository.save(new Dish(data));
	}
	
	@GetMapping(value = "/{id}")
	  public Optional<Dish> getDish(@PathVariable("id") String id) {
	    return dishRepository.findById(id);
	}
}
