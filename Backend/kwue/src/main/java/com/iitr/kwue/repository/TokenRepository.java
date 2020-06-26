package com.iitr.kwue.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iitr.kwue.entities.OneTimePassword;
import com.iitr.kwue.entities.Token;

public interface TokenRepository extends MongoRepository<Token, String> {
	
}
