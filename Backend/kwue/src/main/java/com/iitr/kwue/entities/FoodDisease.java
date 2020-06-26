package com.iitr.kwue.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.iitr.kwue.model.FoodDiseaseId;

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
@Table(name="FoodDisease", schema="test")
@Entity
@IdClass(FoodDiseaseId.class)
public class FoodDisease {
	    @Id
	    private String food;
		 
	    @Id
	    private String disease;
}
