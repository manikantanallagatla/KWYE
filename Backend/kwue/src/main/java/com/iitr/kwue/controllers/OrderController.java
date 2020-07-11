package com.iitr.kwue.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List; 
import java.util.Optional;

import com.iitr.kwue.entities.Order;
import com.iitr.kwue.repository.OrderRepository;
import com.iitr.kwue.service.impl.UserServiceImpl;

//this call needs to be optional sometimes
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/placeOrder")
	public String placeOrder(String phoneNo, String otp, int dishId) {
		if (userServiceImpl.verifyOtp(phoneNo,otp)) {
			Order order = orderRepository.save(new Order(dishId));
			return order.orderId;
		}
		return "not found";
	}
	
	@GetMapping(value = "/getOrderStatus")
	public String getOrderStatus(String phoneNo, String otp, String orderId) {
		if (userServiceImpl.verifyOtp(phoneNo,otp)) {
			Optional<Order> order = orderRepository.findById(orderId);
			if (order != null) {
				return order.get().status;
			}
		}
		return "not authorised";
	}
	
	@GetMapping(value = "/cancelOrder")
	public boolean cancelOrder(String orderId) {
		Optional<Order> order = orderRepository.findById(orderId);
		if (order != null) {
			order.get().status = "Cancelled";
			return true;
		}
		return false;
	}
	
	// try catch would be better here
	@GetMapping(value = "/cancelAllOrder")
	public void cancelAllOrder() {
		orderRepository.deleteAll();
	}
	
	//this function needs to be implemented
	@GetMapping(value = "/getNewOrdersPlaced")
	public List<Integer> getNewOrdersPlaced(Timestamp timestamp) {
		List<Integer> l = new ArrayList<Integer>();
	    return l;
	}
	
	@GetMapping(value = "/getOrder")
	public Optional<Order> getOrder(String orderId) {
		return orderRepository.findById(orderId);
	}
	
	@GetMapping(value = "/updateOrder")
	public boolean updateOrder(String orderId, String orderStatus) {
		Optional<Order> order = orderRepository.findById(orderId);
		if (order != null) {
			order.get().status = orderStatus;
			return true;
		}
		return false;
	}
	
	// this needs to be implemented
	@GetMapping(value = "/getNewOrdersToDeliver")
	public List<String> getNewOrdersToDeliver(String dishId, Timestamp timestamp) {
	    List<String> ids = new ArrayList<String>();
	    return ids;
	}
}
