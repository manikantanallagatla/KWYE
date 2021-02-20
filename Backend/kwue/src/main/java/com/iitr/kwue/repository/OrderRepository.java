package com.iitr.kwue.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iitr.kwue.entities.Order;

public interface OrderRepository extends MongoRepository<Order, String>{

}
