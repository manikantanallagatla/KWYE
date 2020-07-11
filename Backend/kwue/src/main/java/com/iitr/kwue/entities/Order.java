package com.iitr.kwue.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "Orders")
public class Order {
	@Id
	@Field(name="orderId")
	public String orderId;
	public Integer dishId;
	public String status;
	
	public Order(int dishId) {
		this.dishId = dishId;
		this.status = "Received";
	} 
}