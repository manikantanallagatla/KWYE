package com.iitr.kwue.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iitr.kwue.entities.OneTimePassword;

public interface OneTimePasswordRepository extends MongoRepository<OneTimePassword, String> {
	
}
