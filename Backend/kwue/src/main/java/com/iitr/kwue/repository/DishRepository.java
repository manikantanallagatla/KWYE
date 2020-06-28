package com.iitr.kwue.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iitr.kwue.entities.Dish;

public interface DishRepository extends MongoRepository<Dish, String>{

}
