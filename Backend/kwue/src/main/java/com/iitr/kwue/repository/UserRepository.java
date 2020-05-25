package com.iitr.kwue.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.iitr.kwue.entities.User;

public interface UserRepository extends MongoRepository<User, String>{
	//User findBy_id(ObjectId _id);

}