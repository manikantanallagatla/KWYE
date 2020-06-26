package com.iitr.kwue.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class FoodDiseaseId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String food;
	 
    private String disease;

}
